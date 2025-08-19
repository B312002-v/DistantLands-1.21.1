package net.beastguy.distantlandsmc.util;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ALL_BLOCKS = createTag("all_blocks");

        public static final TagKey<Block> ALL_STEM_BLOCKS = createTag("all_stem_blocks");

        public static final TagKey<Block> ALL_HOLLOW_STEM_BLOCKS = createTag("all_hollow_stem_blocks");

        public static final TagKey<Block> ALL_STRIPPED_HOLLOW_STEM_BLOCKS = createTag("all_stripped_hollow_stem_blocks");

        public static final TagKey<Block> ALL_HOLLOW_BLOCKS = createTag("all_hollow_blocks");

        public static final TagKey<Block> ALL_STRIPPED_HOLLOW_BLOCKS = createTag("all_stripped_hollow_blocks");

        public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = createTag("incorrect_for_emerald_tool");
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = createTag("needs_emerald_tool");

        public static final TagKey<Block> PAXEL_MINEABLE = createTag("mineable/paxel");

        public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");

        public static final TagKey<Block> NEEDS_CURSED_RUBY_TOOL = createTag("needs_cursed_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_CURSED_RUBY_TOOL = createTag("incorrect_for_cursed_ruby_tool");

        public static final TagKey<Block> WOODBLOCKSTAGSORTER = createTag("woodblockstagsorter");

        public static final TagKey<Block> WOOD = createTag("wood");
        public static final TagKey<Block> STRIPPED_LOG = createTag("stripped_log");
        public static final TagKey<Block> STRIPPED_WOOD = createTag("stripped_wood");
        public static final TagKey<Block> PLANKS = createTag("planks");
        public static final TagKey<Block> STAIRS = createTag("stairs");
        public static final TagKey<Block> SLAB = createTag("slab");
        public static final TagKey<Block> FENCE = createTag("fence");
        public static final TagKey<Block> FENCE_GATE = createTag("fence_gate");
        public static final TagKey<Block> DOOR = createTag("door");
        public static final TagKey<Block> TRAPDOOR = createTag("trapdoor");
        public static final TagKey<Block> PRESSURE_PLATE = createTag("pressure_plate");
        public static final TagKey<Block> BUTTON = createTag("button");
        public static final TagKey<Block> SIGN = createTag("sign");
        public static final TagKey<Block> CHISELED_BOOKSHELF = createTag("chiseled_bookshelf");
        public static final TagKey<Block> CHEST = createTag("chest");
        public static final TagKey<Block> BARREL = createTag("barrel");
        public static final TagKey<Block> LADDER = createTag("ladder");
        public static final TagKey<Block> HOLLOW_LOGS = createTag("hollow_logs");
        public static final TagKey<Block> STRIPPED_HOLLOW_LOGS = createTag("stripped_hollow_logs");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        public static final TagKey<Item> TOOLSTAGSORTER = createTag("toolstagsorter");

        public static final TagKey<Item> BOWL = createTag("bowl");
        public static final TagKey<Item> STICK = createTag("stick");
        public static final TagKey<Item> BOAT = createTag("boat");
        public static final TagKey<Item> CHEST_BOAT = createTag("chest_boat");
        public static final TagKey<Item> WOODEN_SWORD = createTag("wooden_sword");
        public static final TagKey<Item> WOODEN_PICKAXE = createTag("wooden_pickaxe");
        public static final TagKey<Item> WOODEN_AXE = createTag("wooden_axe");
        public static final TagKey<Item> WOODEN_SHOVEL = createTag("wooden_shovel");
        public static final TagKey<Item> WOODEN_HOE = createTag("wooden_hoe");


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, name));
        }
    }
}
