    package net.beastguy.distantlandsmc.screen.custom;

    import net.beastguy.distantlandsmc.block.ModBlocks;
    import net.beastguy.distantlandsmc.block.entity.CarpenterTableBlockEntity;
    import net.beastguy.distantlandsmc.recipe.CarpenterTableRecipe;
    import net.beastguy.distantlandsmc.recipe.ModRecipeTypes;
    import net.beastguy.distantlandsmc.screen.ModMenuTypes;
    import net.minecraft.network.FriendlyByteBuf;
    import net.minecraft.world.entity.player.Inventory;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.inventory.*;
    import net.minecraft.world.item.ItemStack;
    import net.minecraft.world.item.crafting.RecipeHolder;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.block.entity.BlockEntity;
    import net.neoforged.neoforge.items.SlotItemHandler;
    import org.jetbrains.annotations.NotNull;

    import java.util.List;

    public class CarpenterTableMenu extends AbstractContainerMenu {
        public final CarpenterTableBlockEntity blockEntity;
        private final Level level;
        private final Player player;

        private static final int INPUT_SLOT = 0;
        private static final int OUTPUT_SLOT = 1;

        private static final int HOTBAR_SLOT_COUNT = 9;
        private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
        private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
        private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_ROW_COUNT * PLAYER_INVENTORY_COLUMN_COUNT;
        private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
        private static final int VANILLA_FIRST_SLOT_INDEX = 0;
        private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
        private static final int TE_INVENTORY_SLOT_COUNT = 2;

        private List<RecipeHolder<CarpenterTableRecipe>> availableRecipes = List.of();
        private int selectedRecipeIndex = -1;

        private final ContainerData selectedRecipeData = new ContainerData() {
            private int index = -1;

            @Override
            public int get(int i) {
                return index;
            }

            @Override
            public void set(int i, int value) {
                index = value;
                selectedRecipeIndex = value;
            }

            @Override
            public int getCount() {
                return 1;
            }
        };

        public CarpenterTableMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
            this(pContainerId, inv, getBlockEntityChecked(inv, extraData));
        }

        private static CarpenterTableBlockEntity getBlockEntityChecked(Inventory inv, FriendlyByteBuf extraData) {
            BlockEntity be = inv.player.level().getBlockEntity(extraData.readBlockPos());
            if (!(be instanceof CarpenterTableBlockEntity carpenterTableBlockEntity)) {
                throw new IllegalStateException("BlockEntity não encontrado ou tipo inválido na posição do menu");
            }
            return carpenterTableBlockEntity;
        }

        public CarpenterTableMenu(int pContainerId, Inventory inv, CarpenterTableBlockEntity blockEntity) {
            super(ModMenuTypes.CARPENTER_TABLE_MENU.get(), pContainerId);
            this.blockEntity = blockEntity;
            this.level = inv.player.level();
            this.player = inv.player;

            addPlayerInventory(inv);
            addPlayerHotbar(inv);

            this.addSlot(new SlotItemHandler(blockEntity.itemHandler, INPUT_SLOT, 54, 34) {
                @Override
                public void setChanged() {
                    super.setChanged();
                    blockEntity.setChanged();
                    updateAvailableRecipes();
                    // Não chamar tryCraft() aqui, para evitar crafting automático
                }
            });
            this.addSlot(new SlotItemHandler(blockEntity.itemHandler, OUTPUT_SLOT, 104, 34) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false; // output slot não aceita itens inseridos pelo jogador
                }

                @Override
                public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
                    super.onTake(player, stack);
                    if (!player.level().isClientSide() && !stack.isEmpty()) {
                        craftSelectedRecipe(); // consome input e grava output
                        // NÃO chame updateOutputSlotPreview() aqui
                    }
                }
            });

            addDataSlots(selectedRecipeData);

        }

        // Atualiza a lista de receitas e seleciona a primeira automaticamente
        public void updateAvailableRecipes() {
            ItemStack inputStack = blockEntity.itemHandler.getStackInSlot(INPUT_SLOT);
            if (inputStack.isEmpty()) {
                availableRecipes = List.of();
                selectedRecipeIndex = -1;
                blockEntity.itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);
                return;
            }

            availableRecipes = level.getRecipeManager()
                    .getAllRecipesFor(ModRecipeTypes.CARPENTER_TABLE_TYPE.get())
                    .stream()
                    .filter(recipe -> recipe.value().matches(inputStack))
                    .toList();

            // Se índice atual não for válido, resetar para -1 e limpar output
            if (selectedRecipeIndex < 0 || selectedRecipeIndex >= availableRecipes.size()) {
                selectedRecipeIndex = -1;
                selectedRecipeData.set(0, -1);
                blockEntity.itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);
            } else {
                // índice válido, atualizar preview do output
                selectedRecipeData.set(0, selectedRecipeIndex);
                updateOutputSlotPreview();
            }
        }

        // Executa o crafting de fato: consome input, entrega output e atualiza
        public void craftSelectedRecipe() {
            if (level.isClientSide) return; // adiciona essa linha

            if (selectedRecipeIndex < 0 || selectedRecipeIndex >= availableRecipes.size()) return;

            var recipe = availableRecipes.get(selectedRecipeIndex).value();
            ItemStack output = recipe.output();

            if (!blockEntity.canInsertItemIntoOutputSlot(output) || !blockEntity.canInsertAmountIntoOutputSlot(output.getCount()))
                return;

            blockEntity.itemHandler.extractItem(INPUT_SLOT, 1, false);

            blockEntity.itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);

            blockEntity.setChanged();

        }

        // Atualiza o slot output para mostrar o preview da receita selecionada
        public void updateOutputSlotPreview() {
            if (selectedRecipeIndex < 0 || selectedRecipeIndex >= availableRecipes.size()) {
                blockEntity.itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);
                return;
            }

            ItemStack outputPreview = availableRecipes.get(selectedRecipeIndex).value().output().copy();
            blockEntity.itemHandler.setStackInSlot(OUTPUT_SLOT, outputPreview);
        }

        public int getSelectedRecipeIndex() {
            return selectedRecipeData.get(0);
        }

        public void setSelectedRecipeIndex(int index) {
            selectedRecipeData.set(0, index);
            updateOutputSlotPreview();
        }

        public List<RecipeHolder<CarpenterTableRecipe>> getAvailableRecipes() {
            return availableRecipes;
        }

        @Override
        public boolean clickMenuButton(@NotNull Player player, int buttonId) {
            if (buttonId >= 0 && buttonId < this.availableRecipes.size()) {
                setSelectedRecipeIndex(buttonId); // já chama updateOutputSlotPreview()
                return true;
            }
            return false;
        }

        @Override
        public boolean stillValid(@NotNull Player pPlayer) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    pPlayer, ModBlocks.CARPENTER_TABLE.get());
        }

        private void addPlayerInventory(Inventory playerInventory) {
            for (int i = 0; i < PLAYER_INVENTORY_ROW_COUNT; ++i) {
                for (int j = 0; j < PLAYER_INVENTORY_COLUMN_COUNT; ++j) {
                    this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                }
            }
        }

        private void addPlayerHotbar(Inventory playerInventory) {
            for (int i = 0; i < HOTBAR_SLOT_COUNT; ++i) {
                this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
            }
        }

        @Override
        public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
            Slot sourceSlot = slots.get(index);
            if (!sourceSlot.hasItem()) return ItemStack.EMPTY;
            ItemStack sourceStack = sourceSlot.getItem();
            ItemStack copyOfSourceStack = sourceStack.copy();

            if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
                // Slot do inventário do jogador, tentar mover para o inventário do bloco
                if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
                // Slot do inventário do bloco, mover para o inventário do jogador
                if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                return ItemStack.EMPTY;
            }

            if (sourceStack.isEmpty()) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }

            sourceSlot.onTake(playerIn, sourceStack);
            return copyOfSourceStack;
        }
    }