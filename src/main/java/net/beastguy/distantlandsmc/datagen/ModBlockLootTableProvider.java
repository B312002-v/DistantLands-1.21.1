package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.block.custom.TomatoCropBlock;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
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
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLACK_OPAL_BLOCK.get());
        dropSelf(ModBlocks.RAW_BLACK_OPAL_BLOCK.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.BLACK_OPAL_ORE.get(),
                block -> createOreDrop(ModBlocks.BLACK_OPAL_ORE.get(), ModItems.RAW_BLACK_OPAL.get()));
        this.add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get(), ModItems.RAW_BLACK_OPAL.get(), 2, 5));
        this.add(ModBlocks.BLACK_OPAL_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BLACK_OPAL_END_ORE.get(), ModItems.RAW_BLACK_OPAL.get(), 4, 7));
        this.add(ModBlocks.BLACK_OPAL_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BLACK_OPAL_NETHER_ORE.get(), ModItems.RAW_BLACK_OPAL.get(), 3, 9));

        dropSelf(ModBlocks.BLACK_OPAL_STAIRS.get());
        this.add(ModBlocks.BLACK_OPAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLACK_OPAL_SLAB.get()));

        dropSelf(ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BLACK_OPAL_BUTTON.get());

        dropSelf(ModBlocks.BLACK_OPAL_FENCE.get());
        dropSelf(ModBlocks.BLACK_OPAL_FENCE_GATE.get());
        dropSelf(ModBlocks.BLACK_OPAL_WALL.get());

        dropSelf(ModBlocks.BLACK_OPAL_TRAPDOOR.get());
        this.add(ModBlocks.BLACK_OPAL_DOOR.get(),
                block -> createDoorTable(ModBlocks.BLACK_OPAL_DOOR.get()));

        dropSelf(ModBlocks.BLACK_OPAL_LAMP.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));
        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.asItem(), lootItemConditionBuilder));

        this.dropSelf(ModBlocks.PETUNIA.get());
        this.add(ModBlocks.POTTED_PETUNIA.get(), createPotFlowerItemTable(ModBlocks.PETUNIA));

        dropSelf(ModBlocks.COLORED_LEAVES.get());

        dropSelf(ModBlocks.PEDESTAL.get());

        dropSelf(ModBlocks.CRYSTALLIZER.get());

        this.dropSelf(ModBlocks.HARU_LOG.get());
        this.dropSelf(ModBlocks.HARU_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_HARU_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_HARU_WOOD.get());
        this.dropSelf(ModBlocks.HARU_PLANKS.get());
        this.dropSelf(ModBlocks.HARU_SAPLING.get());
        this.add(ModBlocks.POTTED_HARU_SAPLING.get(), createPotFlowerItemTable(ModBlocks.HARU_SAPLING.get()));

        this.add(ModBlocks.HARU_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.HARU_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        /** BUILDING BLOCKS -------------------------------------------------- */

        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.CURSED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.RUBY_STAIRS.get());
        add(ModBlocks.RUBY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RUBY_SLAB.get()));

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
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
