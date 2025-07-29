package net.beastguy.distantlandsmc.worldgen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_HARU = registerKey("add_tree_haru");
    public static final ResourceKey<BiomeModifier> ADD_SMALL_TREE_HARU = registerKey("add_small_tree_haru");

    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registerKey("add_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_CURSED_RUBY_ORE = registerKey("add_nether_cursed_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_CURSED_RUBY_ORE = registerKey("add_end_cursed_ruby_ore");

    public static final ResourceKey<BiomeModifier> ADD_RUBY_GEODE = registerKey("add_ruby_geode");

    public static final ResourceKey<BiomeModifier> ADD_PETUNIA = registerKey("add_petunia");

    public static final ResourceKey<BiomeModifier> ADD_STONES_PATH = registerKey("add_stones_path");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        /// ORES ----------------------- */
        context.register(ADD_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

//        EXEMPLO PARA BIOMAS INDIVIDUAIS!
//      context.register(ADD_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
//              HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
//              HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBY_ORE_PLACED_KEY)),
//              GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_CURSED_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NEHTER_CURSED_RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_CURSED_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_CURSED_RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RUBY_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBY_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));

        /// NATURE ----------------------- */
        context.register(ADD_PETUNIA, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CHERRY_GROVE), biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PETUNIA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_STONES_PATH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.PURPLE_PLAINS), biomes.getOrThrow(Biomes.CHERRY_GROVE), biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STONES_PATH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        /// TREES ----------------------- */
        context.register(ADD_TREE_HARU, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.PURPLE_PLAINS), biomes.getOrThrow(Biomes.CHERRY_GROVE), biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HARU_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SMALL_TREE_HARU, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.PURPLE_PLAINS), biomes.getOrThrow(Biomes.CHERRY_GROVE), biomes.getOrThrow(Biomes.TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HARU_SMALL_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, name));
    }
}
