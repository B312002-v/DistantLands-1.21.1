package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DistantLandsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
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
                .add(ModBlocks.HARU_PLANKS.get())
                .add(ModBlocks.HARU_LOG.get())
                .add(ModBlocks.HARU_WOOD.get())
                .add(ModBlocks.STRIPPED_HARU_LOG.get())
                .add(ModBlocks.STRIPPED_HARU_WOOD.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.HARU_LOG.get())
                .add(ModBlocks.HARU_WOOD.get())
                .add(ModBlocks.STRIPPED_HARU_LOG.get())
                .add(ModBlocks.STRIPPED_HARU_WOOD.get());

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
    }
}
