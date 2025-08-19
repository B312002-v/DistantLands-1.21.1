package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.item.ModItems;
import net.beastguy.distantlandsmc.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, DistantLandsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BLACK_OPAL.get())
                .add(Items.COAL)
                .add(Items.DANDELION)
                .add(Items.COMPASS);


        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.EMERALD_HELMET.get())
                .add(ModItems.EMERALD_CHESTPLATE.get())
                .add(ModItems.EMERALD_LEGGINGS.get())
                .add(ModItems.EMERALD_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.BLACK_OPAL.get())
                .add(ModItems.RUBY.get())
                .add(ModItems.CURSED_RUBY.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.BEAST_SMITHING_TEMPLATE.get());

        this.tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.EMERALD_SWORD.get());

        this.tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.EMERALD_SWORD.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.HARU_LOG.get().asItem())
                .add(ModBlocks.HARU_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_HARU_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_HARU_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.HARU_PLANKS.asItem());

        this.tag(ItemTags.LOGS)
                .add(ModBlocks.HARU_LOG.asItem())
                .add(ModBlocks.HARU_WOOD.asItem())
                .add(ModBlocks.STRIPPED_HARU_LOG.asItem())
                .add(ModBlocks.STRIPPED_HARU_WOOD.asItem());

        this.tag(ItemTags.BOATS)
                .add(ModItems.HARU_BOAT.get());

        this.tag(ItemTags.CHEST_BOATS)
                .add(ModItems.HARU_CHEST_BOAT.get());

        this.tag(ModTags.Items.BOWL)
                .add(Items.BOWL);

        this.tag(ModTags.Items.STICK)
                .add(Items.STICK);

        this.tag(ModTags.Items.BOAT)
                .addTag(ItemTags.BOATS);

        this.tag(ModTags.Items.CHEST_BOAT)
                .addTag(ItemTags.CHEST_BOATS);

        this.tag(ModTags.Items.WOODEN_SWORD)
                .add(Items.WOODEN_SWORD);

        this.tag(ModTags.Items.WOODEN_PICKAXE)
                .add(Items.WOODEN_PICKAXE);

        this.tag(ModTags.Items.WOODEN_AXE)
                .add(Items.WOODEN_AXE);

        this.tag(ModTags.Items.WOODEN_SHOVEL)
                .add(Items.WOODEN_SHOVEL);

        this.tag(ModTags.Items.WOODEN_HOE)
                .add(Items.WOODEN_HOE);
    }
}
