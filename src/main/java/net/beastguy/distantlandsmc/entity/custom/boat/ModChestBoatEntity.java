package net.beastguy.distantlandsmc.entity.custom.boat;

import net.beastguy.distantlandsmc.entity.ModEntity;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ModChestBoatEntity extends ChestBoat
{
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);


    @Override
    public void tick()
    {
        super.tick();
    }

    public ModChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }

    public ModChestBoatEntity(Level pLevel, double pX, double pY, double pZ)
    {
        this(ModEntity.MOD_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public @NotNull Item getDropItem()
    {
        return switch (getModVariant()) {
            case HARU -> ModItems.HARU_CHEST_BOAT.get();
        };
    }

    public void setVariant(ModBoatEntity.Type pVariant)
    {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, ModBoatEntity.Type.HARU.ordinal());
    }



    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound)
    {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getModVariant().getSerializedName());
        this.addChestVehicleSaveData(pCompound, this.registryAccess());
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag pCompound)
    {
        super.readAdditionalSaveData(pCompound);
        this.readChestVehicleSaveData(pCompound, this.registryAccess());
        if (pCompound.contains("Type", 8))
        {
            this.setVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public ModBoatEntity.Type getModVariant()
    {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}
