package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DistantLandsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(ModBlocks.PETUNIA.get(),
                models().cross(blockTexture(ModBlocks.PETUNIA.get()).getPath(), blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_PETUNIA.get(), models().singleTexture("potted_petunia", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));

        logBlock(((RotatedPillarBlock) ModBlocks.HARU_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.HARU_WOOD.get()), blockTexture(ModBlocks.HARU_LOG.get()), blockTexture(ModBlocks.HARU_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HARU_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HARU_WOOD.get()), blockTexture(ModBlocks.STRIPPED_HARU_LOG.get()), blockTexture(ModBlocks.STRIPPED_HARU_LOG.get()));

        blockItem(ModBlocks.HARU_LOG);
        blockItem(ModBlocks.HARU_WOOD);
        blockItem(ModBlocks.STRIPPED_HARU_LOG);
        blockItem(ModBlocks.STRIPPED_HARU_WOOD);

        blockWithItem(ModBlocks.HARU_PLANKS);

        leavesBlock(ModBlocks.HARU_LEAVES);
        saplingBlock(ModBlocks.HARU_SAPLING);
        simpleBlock(ModBlocks.POTTED_HARU_SAPLING.get(), models().singleTexture("potted_haru_sapling", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.HARU_SAPLING.get())).renderType("cutout"));

        /** BUILDING BLOCKS -------------------------------------------------- */

        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.CURSED_RUBY_BLOCK);

        stairsBlock(ModBlocks.HARU_STAIRS.get(), blockTexture(ModBlocks.HARU_PLANKS.get()));
        slabBlock(ModBlocks.HARU_SLAB.get(), blockTexture(ModBlocks.HARU_PLANKS.get()), blockTexture(ModBlocks.HARU_PLANKS.get()));
        buttonBlock(ModBlocks.HARU_BUTTON.get(), blockTexture(ModBlocks.HARU_PLANKS.get()));
        pressurePlateBlock(ModBlocks.HARU_PRESSURE_PLATE.get(), blockTexture(ModBlocks.HARU_PLANKS.get()));
        fenceBlock(ModBlocks.HARU_FENCE.get(), blockTexture(ModBlocks.HARU_PLANKS.get()));
        fenceGateBlock(ModBlocks.HARU_FENCE_GATE.get(), blockTexture(ModBlocks.HARU_PLANKS.get()));
        doorBlockWithRenderType(ModBlocks.HARU_DOOR.get(), modLoc("block/haru_door_bottom"), modLoc("block/haru_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.HARU_TRAPDOOR.get(), modLoc("block/haru_trapdoor"), true, "cutout");


        blockItem(ModBlocks.HARU_STAIRS);
        blockItem(ModBlocks.HARU_SLAB);
        blockItem(ModBlocks.HARU_FENCE_GATE);
        blockItem(ModBlocks.HARU_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.HARU_PRESSURE_PLATE);

        signBlock(((StandingSignBlock) ModBlocks.HARU_SIGN.get()), ((WallSignBlock) ModBlocks.HARU_WALL_SIGN.get()),
                blockTexture(ModBlocks.HARU_PLANKS.get()));

        hangingSignBlock((CeilingHangingSignBlock) ModBlocks.HARU_HANGING_SIGN.get(), (WallHangingSignBlock) ModBlocks.HARU_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.HARU_PLANKS.get()));

        /** ORES -------------------------------------------------- */

        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.RUBY_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.RUBY_BLACKSTONE_ORE);
        blockWithItem(ModBlocks.NETHER_CURSED_RUBY_ORE);
        blockWithItem(ModBlocks.END_CURSED_RUBY_ORE);

    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(deferredBlock.getId().getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("distantlandsmc:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("distantlandsmc:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
