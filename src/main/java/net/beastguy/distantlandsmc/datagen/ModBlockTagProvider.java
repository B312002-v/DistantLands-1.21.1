package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.HollowLogBlocks;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DistantLandsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {

        this.tag(ModTags.Blocks.ALL_HOLLOW_STEM_BLOCKS)
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.tag(ModTags.Blocks.ALL_STRIPPED_HOLLOW_STEM_BLOCKS)
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.tag(ModTags.Blocks.ALL_STEM_BLOCKS)
                .addTag(ModTags.Blocks.ALL_HOLLOW_STEM_BLOCKS)
                .addTag(ModTags.Blocks.ALL_STRIPPED_HOLLOW_STEM_BLOCKS);


        this.tag(ModTags.Blocks.ALL_HOLLOW_BLOCKS)
                .add(HollowLogBlocks.HARU_HOLLOW_LOG.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.OAK_HOLLOW_LOG.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.tag(ModTags.Blocks.ALL_STRIPPED_HOLLOW_BLOCKS)
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY.get())

                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_EMPTY.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_BOTTON.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_TOP.get())
                .add(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.tag(ModTags.Blocks.ALL_BLOCKS)
                .addTag(ModTags.Blocks.ALL_HOLLOW_BLOCKS)
                .addTag(ModTags.Blocks.ALL_STRIPPED_HOLLOW_BLOCKS)
                .add(ModBlocks.HARU_PLANKS.get())
                .add(ModBlocks.HARU_LOG.get())
                .add(ModBlocks.HARU_WOOD.get())
                .add(ModBlocks.STRIPPED_HARU_LOG.get())
                .add(ModBlocks.STRIPPED_HARU_WOOD.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.RAW_BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get())
                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BLACK_OPAL_STAIRS.get())
                .add(ModBlocks.BLACK_OPAL_SLAB.get())
                .add(ModBlocks.BLACK_OPAL_BUTTON.get())
                .add(ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get())
                .add(ModBlocks.BLACK_OPAL_FENCE.get())
                .add(ModBlocks.BLACK_OPAL_FENCE_GATE.get())
                .add(ModBlocks.BLACK_OPAL_WALL.get())
                .add(ModBlocks.BLACK_OPAL_TRAPDOOR.get())
                .add(ModBlocks.BLACK_OPAL_DOOR.get())

                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.RUBY_DEEPSLATE_ORE.get())
                .add(ModBlocks.NETHER_CURSED_RUBY_ORE.get())
                .add(ModBlocks.END_CURSED_RUBY_ORE.get())

                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.CURSED_RUBY_BLOCK.get())

                .add(ModBlocks.RUBY_STAIRS.get())
                .add(ModBlocks.RUBY_SLAB.get())

                .add(ModBlocks.PABBLE.get())
                .add(ModBlocks.PABBLE_1.get())
                .add(ModBlocks.PABBLE_2.get())
                .add(ModBlocks.ROCK.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.HARU_FENCE.get())
                .add(ModBlocks.HARU_FENCE_GATE.get())
                .add(ModBlocks.HARU_STAIRS.get())
                .add(ModBlocks.HARU_BUTTON.get())
                .add(ModBlocks.HARU_SLAB.get())
                .add(ModBlocks.HARU_PRESSURE_PLATE.get())
                .add(ModBlocks.HARU_TRAPDOOR.get())
                .add(ModBlocks.HARU_DOOR.get());

        this.tag(BlockTags.LOGS)
                .addTag(ModTags.Blocks.ALL_BLOCKS)
                .addTag(ModTags.Blocks.ALL_STEM_BLOCKS);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.ALL_BLOCKS);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get())

                .add(ModBlocks.RUBY_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get())

                .add(ModBlocks.RUBY_DEEPSLATE_ORE.get())
                .add(ModBlocks.NETHER_CURSED_RUBY_ORE.get())
                .add(ModBlocks.END_CURSED_RUBY_ORE.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_RUBY_TOOL);

        tag(ModTags.Blocks.NEEDS_EMERALD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_EMERALD_TOOL);

        tag(BlockTags.STAIRS)
                .add(ModBlocks.RUBY_STAIRS.get())
                .add(ModBlocks.HARU_STAIRS.get());
        tag(BlockTags.SLABS)
                .add(ModBlocks.RUBY_SLAB.get())
                .add(ModBlocks.HARU_SLAB.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.HARU_FENCE.get());
        tag(BlockTags.FENCES)
                .add(ModBlocks.BLACK_OPAL_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.HARU_FENCE_GATE.get())
                .add(ModBlocks.BLACK_OPAL_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.BLACK_OPAL_WALL.get());
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.HARU_BUTTON.get());
        tag(BlockTags.DOORS)
                .add(ModBlocks.HARU_DOOR.get());
        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.HARU_TRAPDOOR.get());
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.HARU_PRESSURE_PLATE.get());

        this.tag(ModTags.Blocks.WOOD)
                .add(Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD,
                        Blocks.ACACIA_WOOD, Blocks.DARK_OAK_WOOD, Blocks.BAMBOO_MOSAIC, Blocks.CHERRY_WOOD,
                        Blocks.CRIMSON_HYPHAE, Blocks.WARPED_HYPHAE, ModBlocks.HARU_WOOD.get(), Blocks.MANGROVE_WOOD);

        this.tag(ModTags.Blocks.STRIPPED_LOG)
                .add(Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_JUNGLE_LOG,
                        Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_BAMBOO_BLOCK, Blocks.STRIPPED_CHERRY_LOG,
                        Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_WARPED_STEM, ModBlocks.STRIPPED_HARU_LOG.get(), Blocks.STRIPPED_MANGROVE_LOG);

        this.tag(ModTags.Blocks.STRIPPED_WOOD)
                .add(Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, Blocks.STRIPPED_BIRCH_WOOD, Blocks.STRIPPED_JUNGLE_WOOD,
                        Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.STRIPPED_CHERRY_WOOD, Blocks.STRIPPED_CRIMSON_HYPHAE,
                        Blocks.STRIPPED_WARPED_HYPHAE, ModBlocks.STRIPPED_HARU_WOOD.get(), Blocks.STRIPPED_MANGROVE_WOOD);

        this.tag(ModTags.Blocks.PLANKS)
                .add(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS,
                        Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.CHERRY_PLANKS, ModBlocks.HARU_PLANKS.get(),
                        Blocks.MANGROVE_PLANKS, Blocks.WARPED_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.BAMBOO_PLANKS);

        this.tag(ModTags.Blocks.STAIRS)
                .add(Blocks.OAK_STAIRS, Blocks.SPRUCE_STAIRS, Blocks.BIRCH_STAIRS, Blocks.JUNGLE_STAIRS,
                        Blocks.ACACIA_STAIRS, Blocks.DARK_OAK_STAIRS, Blocks.CHERRY_STAIRS, ModBlocks.HARU_STAIRS.get(),
                        Blocks.MANGROVE_STAIRS, Blocks.WARPED_STAIRS, Blocks.CRIMSON_STAIRS, Blocks.BAMBOO_STAIRS, Blocks.BAMBOO_MOSAIC_STAIRS);

        this.tag(ModTags.Blocks.SLAB)
                .add(Blocks.OAK_SLAB, Blocks.SPRUCE_SLAB, Blocks.BIRCH_SLAB, Blocks.JUNGLE_SLAB,
                        Blocks.ACACIA_SLAB, Blocks.DARK_OAK_SLAB, Blocks.CHERRY_SLAB, ModBlocks.HARU_SLAB.get(),
                        Blocks.MANGROVE_SLAB, Blocks.WARPED_SLAB, Blocks.CRIMSON_SLAB, Blocks.BAMBOO_SLAB, Blocks.BAMBOO_MOSAIC_SLAB);

        this.tag(ModTags.Blocks.FENCE)
                .add(Blocks.OAK_FENCE, Blocks.SPRUCE_FENCE, Blocks.BIRCH_FENCE, Blocks.JUNGLE_FENCE,
                        Blocks.ACACIA_FENCE, Blocks.DARK_OAK_FENCE, Blocks.CHERRY_FENCE, ModBlocks.HARU_FENCE.get(),
                        Blocks.MANGROVE_FENCE, Blocks.WARPED_FENCE, Blocks.CRIMSON_FENCE, Blocks.BAMBOO_FENCE);

        this.tag(ModTags.Blocks.FENCE_GATE)
                .add(Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE,
                        Blocks.ACACIA_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.CHERRY_FENCE_GATE, ModBlocks.HARU_FENCE_GATE.get(),
                        Blocks.MANGROVE_FENCE_GATE, Blocks.WARPED_FENCE_GATE, Blocks.CRIMSON_FENCE_GATE, Blocks.BAMBOO_FENCE_GATE);

        this.tag(ModTags.Blocks.DOOR)
                .add(Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR,
                        Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CHERRY_DOOR, ModBlocks.HARU_DOOR.get(),
                        Blocks.MANGROVE_DOOR, Blocks.WARPED_DOOR, Blocks.CRIMSON_DOOR, Blocks.BAMBOO_DOOR);

        this.tag(ModTags.Blocks.TRAPDOOR)
                .add(Blocks.OAK_TRAPDOOR, Blocks.SPRUCE_TRAPDOOR, Blocks.BIRCH_TRAPDOOR, Blocks.JUNGLE_TRAPDOOR,
                        Blocks.ACACIA_TRAPDOOR, Blocks.DARK_OAK_TRAPDOOR, Blocks.CHERRY_TRAPDOOR, ModBlocks.HARU_TRAPDOOR.get(),
                        Blocks.MANGROVE_TRAPDOOR, Blocks.WARPED_TRAPDOOR, Blocks.CRIMSON_TRAPDOOR, Blocks.BAMBOO_TRAPDOOR);

        this.tag(ModTags.Blocks.PRESSURE_PLATE)
                .add(Blocks.OAK_PRESSURE_PLATE, Blocks.SPRUCE_PRESSURE_PLATE, Blocks.BIRCH_PRESSURE_PLATE, Blocks.JUNGLE_PRESSURE_PLATE,
                        Blocks.ACACIA_PRESSURE_PLATE, Blocks.DARK_OAK_PRESSURE_PLATE, Blocks.CHERRY_PRESSURE_PLATE, ModBlocks.HARU_PRESSURE_PLATE.get(),
                        Blocks.MANGROVE_PRESSURE_PLATE, Blocks.WARPED_PRESSURE_PLATE, Blocks.CRIMSON_PRESSURE_PLATE, Blocks.BAMBOO_PRESSURE_PLATE);

        this.tag(ModTags.Blocks.BUTTON)
                .add(Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON,
                        Blocks.ACACIA_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.CHERRY_BUTTON, ModBlocks.HARU_BUTTON.get(),
                        Blocks.MANGROVE_BUTTON, Blocks.WARPED_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.BAMBOO_BUTTON);

        this.tag(ModTags.Blocks.SIGN)
                .add(Blocks.OAK_SIGN, Blocks.SPRUCE_SIGN, Blocks.BIRCH_SIGN, Blocks.JUNGLE_SIGN,
                        Blocks.ACACIA_SIGN, Blocks.DARK_OAK_SIGN, Blocks.CHERRY_SIGN, ModBlocks.HARU_SIGN.get(),
                        Blocks.MANGROVE_SIGN, Blocks.WARPED_SIGN, Blocks.CRIMSON_SIGN, Blocks.BAMBOO_SIGN);

        this.tag(ModTags.Blocks.CHISELED_BOOKSHELF)
                .add(Blocks.CHISELED_BOOKSHELF);

        this.tag(ModTags.Blocks.CHEST)
                .add(Blocks.CHEST);

        this.tag(ModTags.Blocks.BARREL)
                .add(Blocks.BARREL);

        this.tag(ModTags.Blocks.LADDER)
                .add(Blocks.LADDER);

        this.tag(ModTags.Blocks.HOLLOW_LOGS)
                .addTag(ModTags.Blocks.ALL_HOLLOW_BLOCKS)
                .addTag(ModTags.Blocks.ALL_HOLLOW_STEM_BLOCKS);

        this.tag(ModTags.Blocks.STRIPPED_HOLLOW_LOGS)
                .addTag(ModTags.Blocks.ALL_STRIPPED_HOLLOW_BLOCKS)
                .addTag(ModTags.Blocks.ALL_STRIPPED_HOLLOW_STEM_BLOCKS);
    }
}
