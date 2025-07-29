package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.enchantment.ModEnchantments;
import net.beastguy.distantlandsmc.trim.ModTrimMaterials;
import net.beastguy.distantlandsmc.trim.ModTrimPatterns;
import net.beastguy.distantlandsmc.worldgen.ModBiomeModifiers;
import net.beastguy.distantlandsmc.worldgen.ModConfiguredFeatures;
import net.beastguy.distantlandsmc.worldgen.ModPlacedFeatures;
import net.beastguy.distantlandsmc.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)

            .add(Registries.BIOME, ModBiomes::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DistantLandsMod.MODID));
    }
}
