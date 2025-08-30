package net.beastguy.distantlandsmc.worldgen.biome;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.worldgen.biome.region.NetherRegion;
import net.beastguy.distantlandsmc.worldgen.biome.region.OverworldRegion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.Regions;

public class ModBiomes {
    public static final ResourceKey<Biome> END_ROT = registerBiomeKey("end_rot");
    public static final ResourceKey<Biome> PURPLE_PLAINS = registerBiomeKey("purple_plains");

    public static void registerBiomes() {
        Regions.register(new OverworldRegion(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "distantlandsmc_overworld"), 20));
        Regions.register(new NetherRegion(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "distantlandsmc_nether"), 20));

        EndBiomeRegistry.registerHighlandsBiome(END_ROT, 20);
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        var carver = context.lookup(Registries.CONFIGURED_CARVER);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, END_ROT, ModEndBiomes.endRot(placedFeatures, carver));
        register(context, PURPLE_PLAINS, ModOverworldBiomes.purplePlains(placedFeatures, carver));
    }


    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    private static ResourceKey<Biome> registerBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, name));
    }
}
