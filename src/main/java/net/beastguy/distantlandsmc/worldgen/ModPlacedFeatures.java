package net.beastguy.distantlandsmc.worldgen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> HARU_PLACED_KEY = registerKey("haru_placed");
    public static final ResourceKey<PlacedFeature> HARU_SMALL_PLACED_KEY = registerKey("haru_small_placed");

    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> NEHTER_CURSED_RUBY_ORE_PLACED_KEY = registerKey("nether_cursed_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> END_CURSED_RUBY_ORE_PLACED_KEY = registerKey("end_cursed_ruby_ore_placed");

    public static final ResourceKey<PlacedFeature> RUBY_GEODE_PLACED_KEY = registerKey("ruby_geode_placed");

    public static final ResourceKey<PlacedFeature> PETUNIA_PLACED_KEY = registerKey("petunia_placed");

    public static final ResourceKey<PlacedFeature> PURPLE_GRASS_PLACED_KEY = registerKey("purple_grass_placed");

    public static final ResourceKey<PlacedFeature> STONES_PATH_PLACED_KEY = registerKey("stones_path_placed");

    public static final ResourceKey<PlacedFeature> SAND_DISK_PLACED_KEY = registerKey("sand_disk_placed");
    public static final ResourceKey<PlacedFeature> GRAVEL_DISK_PLACED_KEY = registerKey("gravel_disk_placed");
    public static final ResourceKey<PlacedFeature> CLAY_DISK_PLACED_KEY = registerKey("clay_disk_placed");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        /// ORES ----------------------- */
        register(context, RUBY_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));

        register(context, NEHTER_CURSED_RUBY_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_CURSED_RUBY_ORE_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(6),
                                VerticalAnchor.absolute(32)),
                        BiomeFilter.biome()
                ));

        register(context, END_CURSED_RUBY_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.END_CURSED_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(20),
                                VerticalAnchor.absolute(64))));

        register(context, RUBY_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)),
                        BiomeFilter.biome()));

        /// NATURE ----------------------- */
        register(context, PETUNIA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PETUNIA_KEY),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, PURPLE_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PURPLE_GRASS_KEY),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, STONES_PATH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STONES_PATH_KEY),
                List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        /// TREES ----------------------- */
        register(context, HARU_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HARU_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1),
                        ModBlocks.HARU_SAPLING.get()));

        register(context, HARU_SMALL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HARU_SMALL_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.05f, 1),
                        ModBlocks.HARU_SAPLING.get()));

        /// SEA FEATURES ----------------------- */

        register(
                context,
                ModPlacedFeatures.SAND_DISK_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.SAND_DISK_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                        BiomeFilter.biome()
                )
        );

        register(
                context,
                ModPlacedFeatures.GRAVEL_DISK_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAVEL_DISK_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BiomeFilter.biome()
                )
        );

        // Disk de CLAY
        register(
                context,
                ModPlacedFeatures.CLAY_DISK_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.CLAY_DISK_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                        BiomeFilter.biome()
                )
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
