package net.beastguy.distantlandsmc.worldgen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HARU_KEY = registerKey("haru");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HARU_SMALL_KEY = registerKey("haru_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_CURSED_RUBY_ORE_KEY = registerKey("nether_cursed_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_CURSED_RUBY_ORE_KEY = registerKey("end_cursed_ruby_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_GEODE_KEY = registerKey("ruby_geode");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PETUNIA_KEY = registerKey("petunia");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_GRASS_KEY = registerKey("purple_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STONES_PATH_KEY = registerKey("stones_path");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SAND_DISK_KEY = registerKey("sand_disk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAVEL_DISK_KEY = registerKey("gravel_disk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLAY_DISK_KEY = registerKey("clay_disk");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        /// ORES ----------------------- */
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RUBY_DEEPSLATE_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 9));
        register(context, NETHER_CURSED_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_CURSED_RUBY_ORE.get().defaultBlockState(), 9));
        register(context, END_CURSED_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.END_CURSED_RUBY_ORE.get().defaultBlockState(), 3));

        register(
                context,
                RUBY_GEODE_KEY,
                Feature.GEODE,
                new GeodeConfiguration(
                        new GeodeBlockSettings(
                                BlockStateProvider.simple(Blocks.AIR),
                                BlockStateProvider.simple(Blocks.BLACKSTONE),
                                BlockStateProvider.simple(Blocks.GILDED_BLACKSTONE),
                                BlockStateProvider.simple(Blocks.POLISHED_BLACKSTONE),
                                BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                                List.of(
                                        ModBlocks.RUBY_BLACKSTONE_ORE.get().defaultBlockState()
                                ),
                                BlockTags.FEATURES_CANNOT_REPLACE,
                                BlockTags.GEODE_INVALID_BLOCKS
                        ),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35,
                        0.083,
                        true,
                        UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2),
                        -16,
                        16,
                        0.05,
                        1
                )
        );


        /// TREES ----------------------- */
        register(context, HARU_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HARU_LOG.get()),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.simple(ModBlocks.HARU_LEAVES.get()),
                new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)),

                new TwoLayersFeatureSize(1, 1, 2))

                        .build());

        register(context, HARU_SMALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HARU_LOG.get()),
                new StraightTrunkPlacer(5, 2, 1), // tronco menor e reto

                BlockStateProvider.simple(ModBlocks.HARU_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)),

                new TwoLayersFeatureSize(2, 0, 2)) // tamanho menor para camada de folhas

                .build());

        /// NATURE ----------------------- */
        register(context, PETUNIA_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PETUNIA.get())))));

        register(context, PURPLE_GRASS_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                128, 6, 2,
                PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.PETUNIA.get().defaultBlockState(), 5)
                                .add(Blocks.TALL_GRASS.defaultBlockState(), 3)
                                .add(Blocks.PINK_PETALS.defaultBlockState(), 3)
                                .add(Blocks.SHORT_GRASS.defaultBlockState(), 4)
                                .add(Blocks.OXEYE_DAISY.defaultBlockState(), 2)

                        ))
                )
        ));

        register(context, STONES_PATH_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                16, 4, 1,
                PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                // Para STICK_GROUND, adiciona os estados para cada direção:
                                .add(ModBlocks.STICK_GROUND.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), 1)
                                .add(ModBlocks.STICK_GROUND.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), 1)
                                .add(ModBlocks.STICK_GROUND.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), 1)
                                .add(ModBlocks.STICK_GROUND.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), 1)
                                .add(ModBlocks.PABBLE.get().defaultBlockState(), 4)
                                .add(ModBlocks.PABBLE_1.get().defaultBlockState(), 4)
                                .add(ModBlocks.PABBLE_2.get().defaultBlockState(), 3)
                                .add(ModBlocks.ROCK.get().defaultBlockState(), 1)
                        )),
                        // Gera apenas quando o bloco embaixo for grass_block
                        BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.GRASS_BLOCK),
                                BlockPredicate.matchesBlocks(Blocks.AIR)
                        )
                )
        ));

        /// SEA FEATURES ----------------------- */

        // Disk de SAND
        register(
                context,
                SAND_DISK_KEY,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.SAND),
                        BlockPredicate.matchesBlocks(Blocks.STONE, Blocks.SAND, Blocks.DIRT, Blocks.GRASS_BLOCK),
                        UniformInt.of(5, 8), // raio um pouco maior para aparecer mais
                        2
                )
        );

        // Disk de GRAVEL
        register(
                context,
                GRAVEL_DISK_KEY,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.GRAVEL),
                        BlockPredicate.matchesBlocks(Blocks.STONE, Blocks.GRAVEL, Blocks.DIRT),
                        UniformInt.of(5, 8), // raio maior para mais presença
                        2
                )
        );

        // Disk de CLAY
        register(
                context,
                CLAY_DISK_KEY,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.CLAY),
                        BlockPredicate.matchesBlocks(Blocks.STONE, Blocks.DIRT),
                        UniformInt.of(3, 6),
                        2
                )
        );

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
