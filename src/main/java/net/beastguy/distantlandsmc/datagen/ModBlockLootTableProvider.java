package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.block.HollowLogBlocks;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.PETUNIA.get());
        this.add(ModBlocks.POTTED_PETUNIA.get(), createPotFlowerItemTable(ModBlocks.PETUNIA));

        dropSelf(ModBlocks.PEDESTAL.get());

        this.dropSelf(ModBlocks.HARU_SAPLING.get());
        this.add(ModBlocks.POTTED_HARU_SAPLING.get(), createPotFlowerItemTable(ModBlocks.HARU_SAPLING.get()));

        this.add(ModBlocks.HARU_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.HARU_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.CARPENTER_TABLE.get());

        /** BUILDING BLOCKS -------------------------------------------------- */

        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.CURSED_RUBY_BLOCK.get());

        dropSelf(ModBlocks.HARU_STAIRS.get());
        dropSelf(ModBlocks.HARU_SLAB.get());
        dropSelf(ModBlocks.HARU_FENCE.get());
        dropSelf(ModBlocks.HARU_FENCE_GATE.get());
        dropSelf(ModBlocks.HARU_BUTTON.get());
        dropSelf(ModBlocks.HARU_TRAPDOOR.get());
        dropSelf(ModBlocks.HARU_PRESSURE_PLATE.get());
        add(ModBlocks.HARU_DOOR.get(),
                block -> createDoorTable(ModBlocks.HARU_DOOR.get()));

        this.add(ModBlocks.HARU_SIGN.get(), block ->
                createSingleItemTable(ModItems.HARU_SIGN.get()));

        this.add(ModBlocks.HARU_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.HARU_SIGN.get()));

        this.add(ModBlocks.HARU_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.HARU_HANGING_SIGN.get()));

        this.add(ModBlocks.HARU_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.HARU_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.HARU_PLANKS.get());

        this.dropSelf(ModBlocks.HARU_LOG.get());
        this.dropSelf(ModBlocks.HARU_WOOD.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.HARU_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(ModBlocks.STRIPPED_HARU_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_HARU_WOOD.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.CHERRY_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.BAMBOO_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_EMPTY.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_BOTTON.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_TOP.get());
        this.dropSelf(HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_EMPTY.get());

        /** NATURE -------------------------------------------------- */

        this.add(ModBlocks.STICK_GROUND.get(), createDropWithSilkTouch(ModBlocks.STICK_GROUND.get(), Items.STICK));

        this.add(ModBlocks.PABBLE.get(), createDropWithSilkTouch(ModBlocks.PABBLE.get(), ModItems.SMALL_STONE.get()));
        this.add(ModBlocks.PABBLE_1.get(), createDropWithSilkTouch(ModBlocks.PABBLE_1.get(), ModItems.SMALL_STONE.get()));
        this.add(ModBlocks.PABBLE_2.get(), createDropWithSilkTouch(ModBlocks.PABBLE_2.get(), ModItems.SMALL_STONE.get()));
        this.add(ModBlocks.ROCK.get(), createDropWithSilkTouch(ModBlocks.ROCK.get(), Items.COBBLESTONE));

        /** ORES -------------------------------------------------- */

        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.RUBY_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_DEEPSLATE_ORE.get(), ModItems.RUBY.get()));

        this.add(ModBlocks.RUBY_BLACKSTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_BLACKSTONE_ORE.get(), ModItems.RUBY.get()));


        this.add(ModBlocks.NETHER_CURSED_RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_CURSED_RUBY_ORE.get(), ModItems.CURSED_RUBY.get()));
        this.add(ModBlocks.END_CURSED_RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.END_CURSED_RUBY_ORE.get(), ModItems.CURSED_RUBY.get()));


    }

    protected LootTable.Builder createDropWithSilkTouch(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                LootItem.lootTableItem(item) // dropa o item vanilla
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
        );
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
