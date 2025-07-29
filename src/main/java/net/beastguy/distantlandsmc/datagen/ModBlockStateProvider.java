package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.block.custom.BlackOpalLampBlock;
import net.beastguy.distantlandsmc.block.custom.TomatoCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.awt.*;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DistantLandsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);
        blockWithItem(ModBlocks.RAW_BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.BLACK_OPAL_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE );
        blockWithItem(ModBlocks.BLACK_OPAL_END_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.BLACK_OPAL_STAIRS.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.BLACK_OPAL_SLAB.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.BLACK_OPAL_BUTTON.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.BLACK_OPAL_FENCE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BLACK_OPAL_FENCE_GATE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.BLACK_OPAL_WALL.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLACK_OPAL_DOOR.get()), modLoc("block/black_opal_door_bottom"), modLoc("block/black_opal_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLACK_OPAL_TRAPDOOR.get()), modLoc("block/black_opal_trapdoor"), true, "cutout");

        blockItem(ModBlocks.BLACK_OPAL_STAIRS);
        blockItem(ModBlocks.BLACK_OPAL_SLAB);
        blockItem(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
        blockItem(ModBlocks.BLACK_OPAL_FENCE_GATE);

        blockItem(ModBlocks.BLACK_OPAL_TRAPDOOR, "_bottom");

        customLamp();

        makeCrop(((TomatoCropBlock) ModBlocks.TOMATO_CROP.get()), "tomato_crop_stage","tomato_crop_stage");

        simpleBlock(ModBlocks.PETUNIA.get(),
                models().cross(blockTexture(ModBlocks.PETUNIA.get()).getPath(), blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_PETUNIA.get(), models().singleTexture("potted_petunia", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));

        leavesBlock(ModBlocks.COLORED_LEAVES);

        horizontalBlock(ModBlocks.CRYSTALLIZER.get(), mcLoc("block/blast_furnace_side"), modLoc("block/crystallizer_front"), mcLoc("block/blast_furnace_top"));

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

        stairsBlock(ModBlocks.RUBY_STAIRS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        slabBlock(ModBlocks.RUBY_SLAB.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        blockItem(ModBlocks.RUBY_STAIRS);
        blockItem(ModBlocks.RUBY_SLAB);

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

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "block/" + textureName +
                        state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.BLACK_OPAL_LAMP.get()).forAllStates(state -> {
            if(state.getValue(BlackOpalLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("black_opal_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "block/" + "black_opal_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("black_opal_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "block/" + "black_opal_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.BLACK_OPAL_LAMP.get(), models().cubeAll("black_opal_lamp_on",
                ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "block/" + "black_opal_lamp_on")));
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
