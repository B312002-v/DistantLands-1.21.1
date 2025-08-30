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
        // Agora adicionando PURPLE_PLAINS com parâmetros próximos aos plains clássicos
        new ParameterPointListBuilder()
                .temperature(Temperature.ICY, Temperature.COOL)
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_2)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING)
                .build()
                .forEach(point -> builder.add(point, ModBiomes.PURPLE_PLAINS));

        builder.build().forEach(mapper);
    }
}