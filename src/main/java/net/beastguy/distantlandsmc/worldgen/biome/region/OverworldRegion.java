package net.beastguy.distantlandsmc.worldgen.biome.region;

import com.mojang.datafixers.util.Pair;
import net.beastguy.distantlandsmc.worldgen.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class OverworldRegion extends Region {
    public OverworldRegion(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        // Overlap Vanilla's parameters with our own for our COLD_BLUE biome.
        // The parameters for this biome are chosen arbitrarily.
        new ParameterPointListBuilder()
            .temperature(Temperature.span(Temperature.COOL, Temperature.FROZEN))
            .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
            .continentalness(Continentalness.INLAND)
            .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
            .depth(Depth.SURFACE, Depth.FLOOR)
            .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
            .build().forEach(point -> builder.add(point, ModBiomes.KAUPEN_VALLEY));

        // Add our points to the mapper
        builder.build().forEach(mapper);

        // Agora adicionando PURPLE_PLAINS com parâmetros próximos aos plains clássicos
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))       // igual plains
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))                 // igual plains
                .continentalness(Continentalness.span(Continentalness.INLAND, Continentalness.NEAR_INLAND)) // igual plains
                .erosion(Erosion.EROSION_3, Erosion.EROSION_4)                              // terreno plano a levemente ondulado
                .depth(Depth.SURFACE)                                                      // superfície padrão
                .weirdness(Weirdness.span(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING)) // distribuição comum
                .build()
                .forEach(point -> builder.add(point, ModBiomes.PURPLE_PLAINS));

        builder.build().forEach(mapper);
    }
}