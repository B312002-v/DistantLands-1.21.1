package net.beastguy.distantlandsmc.entity.custom.boat;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ModBoatRenderer extends BoatRenderer
{
    private final Map<ModBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ModBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.boatResources = Stream.of(ModBoatEntity.Type.values())
                .collect(ImmutableMap.toImmutableMap(
                        type -> Objects.requireNonNull(type, "Enum type cannot be null"),
                        type -> Pair.of(
                                DistantLandsMod.rl(getTextureLocation(Objects.requireNonNull(type), pChestBoat)),
                                this.createBoatModel(pContext, Objects.requireNonNull(type), pChestBoat)
                        )
                ));
    }

    private static String getTextureLocation(ModBoatEntity.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getSerializedName() + ".png" : "textures/entity/boat/" + pType.getSerializedName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, ModBoatEntity.Type type, boolean chestBoat) {

        ResourceLocation location = DistantLandsMod.rl(type.getSerializedName());

        ModelLayerLocation modellayerlocation = chestBoat ? new ModelLayerLocation(location.withPrefix("chest_boat/"), "main") : new ModelLayerLocation(location.withPrefix("boat/"), "main");
        ModelPart modelpart = context.bakeLayer(modellayerlocation);

        return chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);

    }

    public static ModelLayerLocation createBoatModelName(ModBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getSerializedName());
    }

    public static ModelLayerLocation createChestBoatModelName(ModBoatEntity.Type pType) {
        return createLocation("chest_boat/" + pType.getSerializedName());
    }

    private static ModelLayerLocation createLocation(String pPath) {
        return new ModelLayerLocation(DistantLandsMod.rl(pPath), "main");
    }


    public @NotNull Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(@NotNull Boat boat) {
        if (boat instanceof ModBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        } else if (boat instanceof ModChestBoatEntity modChestBoatEntity) {
            return this.boatResources.get(modChestBoatEntity.getModVariant());
        } else {
            throw new IllegalArgumentException("Unknown boat type: " + boat);
        }
    }

}
