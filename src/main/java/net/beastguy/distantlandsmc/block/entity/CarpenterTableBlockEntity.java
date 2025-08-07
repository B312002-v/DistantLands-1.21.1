package net.beastguy.distantlandsmc.block.entity;

import net.beastguy.distantlandsmc.recipe.CarpenterTableRecipe;
import net.beastguy.distantlandsmc.recipe.CarpenterTableRecipeInput;
import net.beastguy.distantlandsmc.recipe.ModRecipeTypes;
import net.beastguy.distantlandsmc.screen.custom.CarpenterTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CarpenterTableBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    public CarpenterTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CARPENTER_TABLE_BE.get(), pos, state);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.distantlandsmc.carpenter_table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inv, @NotNull Player player) {
        return new CarpenterTableMenu(id, inv, this); // vocÃª pode passar null ou remover completamente o `ContainerData`
    }

    public void drops() {
        if (this.level == null) return;

        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    private Optional<RecipeHolder<CarpenterTableRecipe>> getCurrentRecipe() {
        if (this.level == null) {
            return Optional.empty();
        }

        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.CARPENTER_TABLE_TYPE.get(),
                        new CarpenterTableRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT)),
                        level);
    }

    public boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty()
                || itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    public boolean canInsertAmountIntoOutputSlot(int count) {
        int current = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();
        int max = itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        return current + count <= max;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}