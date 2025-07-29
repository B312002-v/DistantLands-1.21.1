package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, DistantLandsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.WATER)
                .add(ModFluids.SOURCE_BLACK_OPAL_WATER.get())
                .add(ModFluids.FLOWING_BLACK_OPAL_WATER.get());
    }
}
