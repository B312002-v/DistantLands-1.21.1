package net.beastguy.distantlandsmc.screen.custom;

import com.google.common.collect.Lists;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.recipe.FilterableRecipe;
import net.beastguy.distantlandsmc.recipe.ModRecipeTypes;
import net.beastguy.distantlandsmc.recipe.RecipeSorter;
import net.beastguy.distantlandsmc.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CarpenterTableMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    public final Container container;
    private final Slot inputSlot;
    private final Slot resultSlot;

    private final Player player;

    private List<FilterableRecipe> recipes;
    private ItemStack input;
    private long lastSoundTime;
    private final ResultContainer resultContainer;
    private Runnable slotUpdateListener;
    private FilterableRecipe lastSelectedRecipe = null;

    public CarpenterTableMenu(int i, Inventory inventory, FriendlyByteBuf ignoredBuf) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public CarpenterTableMenu(int i, Inventory inventory, final ContainerLevelAccess containerLevelAccess) {
        super(ModMenuTypes.CARPENTER_TABLE_MENU.get(), i);
        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipes = Lists.newArrayList();
        this.input = ItemStack.EMPTY;
        this.slotUpdateListener = () -> {
        };
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
                resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                ItemStack itemStack = inputSlot.remove(recipes.get(selectedRecipeIndex.get())
                        .recipe().value().getInputCount());
                if (!itemStack.isEmpty()) {
                    setupResultSlot();
                }

                containerLevelAccess.execute((level, blockPos) -> {
                    long l = level.getGameTime();
                    if (lastSoundTime != l) {
                        level.playSound(null, blockPos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        lastSoundTime = l;
                    }

                });
                super.onTake(player, stack);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(inputSlot.getItem());
            }
        });

        int j;
        for (j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<FilterableRecipe> getRecipes() {
        return this.recipes;
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.access, player, ModBlocks.CARPENTER_TABLE.get());
    }

    @Override
    public boolean clickMenuButton(@NotNull Player player, int id) {
        // hack since the freaking packet sends a byte not an int
        id = Byte.toUnsignedInt((byte)id);
        if (this.isValidRecipeIndex(id) || id == 255) {
            this.selectedRecipeIndex.set(id);
            this.setupResultSlot();
        }
        return true;
    }

    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipes.size();
    }

    @Override
    public void slotsChanged(@NotNull Container container) {
        ItemStack itemStack = this.inputSlot.getItem();
        ItemStack old = this.input;
        boolean sameStack = itemStack.is(old.getItem());
        int maxItemsThatCanBeConsumed = 5; //I made it the f up
        if (!sameStack || itemStack.getCount() < maxItemsThatCanBeConsumed || old.getCount() < maxItemsThatCanBeConsumed) {
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

            // ** CHAMADA IMPORTANTE NO SERVIDOR: **
            if (!this.level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
                RecipeSorter.accept(matching);
                RecipeSorter.sendOrderToClient(serverPlayer);
            }

            RecipeSorter.sort(matching, this.level);

            recipes = matching.stream().map(FilterableRecipe::of).toList();
            // at most 256 recipes
            recipes = recipes.subList(0, Math.min(recipes.size(), 255));

            //preserve last clicked recipe on recipe change
            if (lastSelectedRecipe != null) {
                int newInd = this.recipes.indexOf(lastSelectedRecipe);
                if (newInd != -1) {
                    this.selectedRecipeIndex.set(newInd);
                }
            }
        }

        lastSelectedRecipe = null;
    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            FilterableRecipe selected = this.recipes.get(this.selectedRecipeIndex.get());
            this.lastSelectedRecipe = selected;
            ItemStack itemStack = selected.recipe().value().assemble(createRecipeInput(container), this.level.registryAccess());
            if (itemStack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(selected.recipe());
                this.resultSlot.set(itemStack);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    @Override
    public @NotNull MenuType<?> getType() {
        return ModMenuTypes.CARPENTER_TABLE_MENU.get();
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

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
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (index == 1) {
                item.onCraftedBy(itemStack2, player.level(), player);
                if (!this.moveItemStackTo(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack2, itemStack);
            } else if (index == 0) {
                if (!this.moveItemStackTo(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(ModRecipeTypes.CARPENTER_TABLE_TYPE.get(),
                    new SingleRecipeInput(itemStack2), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack2);
            this.broadcastChanges();
        }

        return itemStack;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, blockPos) -> this.clearContainer(player, this.container));
    }
}