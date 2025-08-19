    package net.beastguy.distantlandsmc.screen.custom;

    import com.google.common.collect.Lists;
    import net.beastguy.distantlandsmc.block.ModBlocks;
    import net.beastguy.distantlandsmc.recipe.CarpenterTableRecipe;
    import net.beastguy.distantlandsmc.recipe.FilterableRecipe;
    import net.beastguy.distantlandsmc.recipe.ModRecipeTypes;
    import net.beastguy.distantlandsmc.recipe.RecipeSorter;
    import net.beastguy.distantlandsmc.screen.ModMenuTypes;
    import net.beastguy.distantlandsmc.sound.ModSounds;
    import net.minecraft.client.Minecraft;
    import net.minecraft.core.Holder;
    import net.minecraft.core.registries.BuiltInRegistries;
    import net.minecraft.network.FriendlyByteBuf;
    import net.minecraft.server.level.ServerPlayer;
    import net.minecraft.sounds.SoundSource;
    import net.minecraft.tags.TagKey;
    import net.minecraft.world.Container;
    import net.minecraft.world.SimpleContainer;
    import net.minecraft.world.entity.player.Inventory;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.inventory.*;
    import net.minecraft.world.item.Item;
    import net.minecraft.world.item.ItemStack;
    import net.minecraft.world.item.crafting.RecipeHolder;
    import net.minecraft.world.item.crafting.SingleRecipeInput;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.block.Block;
    import org.jetbrains.annotations.NotNull;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;
    import java.util.Objects;

    public class CarpenterTableMenu extends AbstractContainerMenu {
        private final ContainerLevelAccess access;
        private final DataSlot selectedRecipeIndex;
        private final Level level;
        public final Container container;
        private final Slot inputSlot;
        private final Slot resultSlot;
        private final Player player;

        private List<FilterableRecipe> recipes;
        private final List<FilterableRecipe> filteredRecipes = new ArrayList<>();
        private ItemStack input;
        private long lastSoundTime;
        private final ResultContainer resultContainer;
        private Runnable slotUpdateListener;
        private FilterableRecipe lastSelectedRecipe = null;

        private String currentFilter = "";
        private List<TagKey<?>> currentTags = new ArrayList<>();

        public List<TagKey<?>> getCurrentCategoryTags() {
            return currentTags;
        }

        public CarpenterTableMenu(int i, Inventory inventory, FriendlyByteBuf ignoredBuf) {
            this(i, inventory, ContainerLevelAccess.NULL);
        }

        public CarpenterTableMenu(int i, Inventory inventory, final ContainerLevelAccess containerLevelAccess) {
            super(ModMenuTypes.CARPENTER_TABLE_MENU.get(), i);
            this.selectedRecipeIndex = DataSlot.standalone();
            this.recipes = Lists.newArrayList();
            this.input = ItemStack.EMPTY;
            this.slotUpdateListener = () -> {};
            this.container = new SimpleContainer(1) {
                @Override
                public void setChanged() {
                    super.setChanged();
                    slotsChanged(this);
                    slotUpdateListener.run();
                }
            };
            this.resultContainer = new ResultContainer();
            this.access = containerLevelAccess;
            this.level = inventory.player.level();
            this.player = inventory.player;

            this.inputSlot = this.addSlot(new Slot(this.container, 0,21,33));
            this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1,143,33) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }

                @Override
                public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
                    stack.onCraftedBy(player.level(), player, stack.getCount());
                    resultContainer.awardUsedRecipes(player, List.of(inputSlot.getItem()));

                    if (selectedRecipeIndex.get() >= 0 && selectedRecipeIndex.get() < filteredRecipes.size()) {
                        ItemStack itemStack = inputSlot.remove(filteredRecipes.get(selectedRecipeIndex.get())
                                .recipe().value().getInputCount());
                        if (!itemStack.isEmpty()) {
                            setupResultSlot();
                        }
                    }

                    containerLevelAccess.execute((level, blockPos) -> {
                        long l = level.getGameTime();
                        if (lastSoundTime != l) {
                            level.playSound(null, blockPos, ModSounds.CHAINSAW_CUT.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                            lastSoundTime = l;
                        }
                    });

                    super.onTake(player, stack);
                }
            });

            // Inventory slots
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 9; ++k) {
                    this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
                }
            }
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
            }

            this.addDataSlot(this.selectedRecipeIndex);
        }

        public int getSelectedRecipeIndex() { return this.selectedRecipeIndex.get(); }
        public List<FilterableRecipe> getRecipes() { return this.recipes; }
        public List<FilterableRecipe> getFilteredRecipes() { return this.filteredRecipes; }
        public boolean hasInputItem() { return this.inputSlot.hasItem() && !this.recipes.isEmpty(); }

        @Override
        public boolean stillValid(@NotNull Player player) {
            return stillValid(this.access, player, ModBlocks.CARPENTER_TABLE.get());
        }

        @Override
        public boolean clickMenuButton(@NotNull Player player, int id) {
            id = Byte.toUnsignedInt((byte) id);

            // 🔹 Garante que o índice está dentro da lista filtrada
            if (id < filteredRecipes.size()) {

                // Atualiza o índice filtrado para o GUI e preview
                selectedRecipeIndex.set(id);

                // Atualiza o resultado no slot
                setupResultSlot();

                // 🔹 Envia clique ao servidor usando índice real da lista completa
                int actualIndex = recipes.indexOf(filteredRecipes.get(id));
                if (actualIndex >= 0 && player.level().isClientSide()) {
                    Objects.requireNonNull(Minecraft.getInstance().getConnection())
                            .send(new net.minecraft.network.protocol.game.ServerboundContainerButtonClickPacket(this.containerId, actualIndex));
                }
            }

            return true;
        }

        @Override
        public void slotsChanged(@NotNull Container container) {
            ItemStack itemStack = this.inputSlot.getItem();
            boolean sameStack = itemStack.is(input.getItem());
            int maxItemsThatCanBeConsumed = 5;
            if (!sameStack || itemStack.getCount() < maxItemsThatCanBeConsumed || input.getCount() < maxItemsThatCanBeConsumed) {
                this.input = itemStack.copy();
                this.setupRecipeList(container, itemStack);
            }
        }

        private static SingleRecipeInput createRecipeInput(Container container) {
            return new SingleRecipeInput(container.getItem(0));
        }

        private void setupRecipeList(Container container, ItemStack stack) {
            this.selectedRecipeIndex.set(-1);
            this.resultSlot.set(ItemStack.EMPTY);

            if (!stack.isEmpty()) {
                var matching = this.level.getRecipeManager()
                        .getRecipesFor(ModRecipeTypes.CARPENTER_TABLE_TYPE.get(), createRecipeInput(container), this.level);

                RecipeSorter.accept(matching);
                RecipeSorter.sort(matching, this.level);

                if (!this.level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
                    List<RecipeHolder<CarpenterTableRecipe>> safeMatching = new ArrayList<>(matching);
                    RecipeSorter.sendOrderToClient(serverPlayer, safeMatching);
                }

                recipes = matching.stream()
                        .map(FilterableRecipe::of)
                        .limit(256)
                        .toList();

                // Aplica filtro de texto + tags
                applyFilters(currentTags, currentFilter);

                if (lastSelectedRecipe != null) {
                    int newInd = filteredRecipes.indexOf(lastSelectedRecipe);
                    selectedRecipeIndex.set(newInd);
                } else {
                    selectedRecipeIndex.set(-1);
                }
            }
            lastSelectedRecipe = null;
        }

        // --- Filtragem combinada ---
        public void applyFilters(List<TagKey<?>> tags, String textFilter) {
            filteredRecipes.clear();
            currentFilter = (textFilter != null) ? textFilter.toLowerCase(Locale.ROOT) : "";
            currentTags = (tags != null) ? new ArrayList<>(tags) : new ArrayList<>();

            for (FilterableRecipe r : recipes) {
                Item result = r.recipe().value().getResultItem(level.registryAccess()).getItem();

                boolean matchesTag = currentTags.isEmpty();
                for (TagKey<?> tag : currentTags) {
                    if (tag.registry().equals(BuiltInRegistries.BLOCK.key())) {
                        @SuppressWarnings("unchecked")
                        TagKey<Block> blockTag = (TagKey<Block>) tag;
                        var registry = level.registryAccess().registryOrThrow(BuiltInRegistries.BLOCK.key());
                        for (Holder<Block> holder : registry.getTagOrEmpty(blockTag)) {
                            if (holder.value().asItem() == result) {
                                matchesTag = true;
                                break;
                            }
                        }
                    } else if (tag.registry().equals(BuiltInRegistries.ITEM.key())) {
                        @SuppressWarnings("unchecked")
                        TagKey<Item> itemTag = (TagKey<Item>) tag;
                        var registry = level.registryAccess().registryOrThrow(BuiltInRegistries.ITEM.key());
                        for (Holder<Item> holder : registry.getTagOrEmpty(itemTag)) {
                            if (holder.value() == result) {
                                matchesTag = true;
                                break;
                            }
                        }
                    }
                    if (matchesTag) break;
                }

                boolean matchesText = currentFilter.isEmpty() || r.matchFilter(currentFilter);

                if (matchesTag && matchesText) {
                    filteredRecipes.add(r);
                }
            }

            // Nenhuma seleção por padrão
            selectedRecipeIndex.set(-1);
            setupResultSlot();
        }

        public void setTextFilter(String filterText) { applyFilters(currentTags, filterText); }
        public void setCategoryTags(List<TagKey<?>> tags) { applyFilters(tags, currentFilter); }

        void setupResultSlot() {
            if (!filteredRecipes.isEmpty() && selectedRecipeIndex.get() >= 0 && selectedRecipeIndex.get() < filteredRecipes.size()) {
                FilterableRecipe selected = filteredRecipes.get(selectedRecipeIndex.get());
                lastSelectedRecipe = selected;
                ItemStack itemStack = selected.recipe().value().assemble(createRecipeInput(container), level.registryAccess());
                if (itemStack.isItemEnabled(level.enabledFeatures())) {
                    resultContainer.setRecipeUsed(selected.recipe());
                    resultSlot.set(itemStack);
                } else {
                    resultSlot.set(ItemStack.EMPTY);
                }
            } else {
                resultSlot.set(ItemStack.EMPTY);
            }
            broadcastChanges();
        }

        @Override
        public @NotNull MenuType<?> getType() { return ModMenuTypes.CARPENTER_TABLE_MENU.get(); }

        public void registerUpdateListener(Runnable listener) { this.slotUpdateListener = listener; }

        @Override
        public boolean canTakeItemForPickAll(@NotNull ItemStack stack, Slot slot) {
            return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
        }

        @Override
        public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
            ItemStack itemStack = ItemStack.EMPTY;
            Slot slot = this.slots.get(index);
            if (slot.hasItem()) {
                ItemStack itemStack2 = slot.getItem();
                itemStack = itemStack2.copy();
                if (index == 1) {
                    itemStack2.getItem().onCraftedBy(itemStack2, player.level(), player);
                    if (!moveItemStackTo(itemStack2, 2, 38, true)) return ItemStack.EMPTY;
                    slot.onQuickCraft(itemStack2, itemStack);
                } else if (index == 0) {
                    if (!moveItemStackTo(itemStack2, 2, 38, false)) return ItemStack.EMPTY;
                } else if (level.getRecipeManager().getRecipeFor(ModRecipeTypes.CARPENTER_TABLE_TYPE.get(), new SingleRecipeInput(itemStack2), level).isPresent()) {
                    if (!moveItemStackTo(itemStack2, 0, 1, false)) return ItemStack.EMPTY;
                } else if (index >= 2 && index < 29) {
                    if (!moveItemStackTo(itemStack2, 29, 38, false)) return ItemStack.EMPTY;
                } else if (index >= 29 && index < 38 && !moveItemStackTo(itemStack2, 2, 29, false)) return ItemStack.EMPTY;

                if (itemStack2.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
                slot.setChanged();
                if (itemStack2.getCount() == itemStack.getCount()) return ItemStack.EMPTY;
                slot.onTake(player, itemStack2);
                broadcastChanges();
            }
            return itemStack;
        }

        @Override
        public void removed(@NotNull Player player) {
            super.removed(player);
            resultContainer.removeItemNoUpdate(1);
            this.access.execute((level, blockPos) -> this.clearContainer(player, this.container));
        }
    }