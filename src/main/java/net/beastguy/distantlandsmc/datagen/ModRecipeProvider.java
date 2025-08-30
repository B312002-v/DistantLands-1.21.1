package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.RUBY_DEEPSLATE_ORE, ModBlocks.RUBY_BLACKSTONE_ORE);

        List<ItemLike> CURSED_RUBY_SMELTABLES = List.of(ModBlocks.NETHER_CURSED_RUBY_ORE, ModBlocks.END_CURSED_RUBY_ORE);

        /** ITEMS ------------------------------- */

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK)
                .unlockedBy("has_ruby_block", has(ModBlocks.RUBY_BLOCK)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CURSED_RUBY.get(), 9)
                .requires(ModBlocks.CURSED_RUBY_BLOCK)
                .unlockedBy("has_cursed_ruby_block", has(ModBlocks.CURSED_RUBY_BLOCK)).save(pRecipeOutput);

        woodenBoat(pRecipeOutput, ModItems.HARU_BOAT.get(), ModBlocks.HARU_PLANKS.get());
        chestBoat(pRecipeOutput, ModItems.HARU_CHEST_BOAT.get(), ModItems.HARU_BOAT.get());

        /** ORES ------------------------------- */

        /** NATURAL BLOCKS ------------------------------- */

        // HARU_LOG → HARU_PLANKS (4x)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARU_PLANKS.get(), 4)
                .requires(ModBlocks.HARU_LOG.get())
                .unlockedBy("has_haru_log", has(ModBlocks.HARU_LOG.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "haru_planks_from_haru_log"));


        // HARU_WOOD → HARU_PLANKS (4x)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARU_PLANKS.get(), 4)
                .requires(ModBlocks.HARU_WOOD.get())
                .unlockedBy("has_haru_wood", has(ModBlocks.HARU_WOOD.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "haru_planks_from_haru_wood"));

        // STRIPPED_HARU_LOG → HARU_PLANKS (4x)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARU_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_HARU_LOG.get())
                .unlockedBy("has_stripped_haru_log", has(ModBlocks.STRIPPED_HARU_LOG.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "haru_planks_from_stripped_haru_log"));

        // STRIPPED_HARU_WOOD → HARU_PLANKS (4x)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARU_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_HARU_WOOD.get())
                .unlockedBy("has_stripped_haru_wood", has(ModBlocks.STRIPPED_HARU_WOOD.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "haru_planks_from_stripped_haru_wood"));

        // HARU_LOG → HARU_WOOD
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARU_WOOD.get(), 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.HARU_LOG.get())
                .unlockedBy("has_haru_log", has(ModBlocks.HARU_LOG.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "haru_wood_from_haru_log"));

        // STRIPPED_HARU_LOG → STRIPPED_HARU_WOOD
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_HARU_WOOD.get(), 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.STRIPPED_HARU_LOG.get())
                .unlockedBy("has_stripped_haru_log", has(ModBlocks.STRIPPED_HARU_LOG.get()))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "stripped_haru_wood_from_stripped_haru_log"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.SMALL_STONE.get())
                .unlockedBy("has_small_stone", has(ModItems.SMALL_STONE.get()))
                .save(pRecipeOutput);


        /** COOKING RECIPIES ------------------------------- */

        oreSmelting(pRecipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pRecipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");

        oreSmelting(pRecipeOutput, CURSED_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_RUBY.get(), 0.25f, 200, "cursed_ruby");
        oreBlasting(pRecipeOutput, CURSED_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_RUBY.get(), 0.25f, 100, "cursed_ruby");

        /** FUNCTIONAL BLOCKS ------------------------------- */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CARPENTER_TABLE.get())
                .pattern(" I ")
                .pattern("PPP")
                .pattern("L L")
                .define('I', Items.IRON_INGOT)
                .define('P', ItemTags.PLANKS)
                .define('L', ItemTags.LOGS)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(pRecipeOutput);

        /** BUILDING BLOCKS ------------------------------- */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RUBY.get())
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CURSED_RUBY_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.CURSED_RUBY.get())
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);

        stairBuilder(ModBlocks.HARU_STAIRS.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARU_SLAB.get(), ModBlocks.HARU_PLANKS.get());

        buttonBuilder(ModBlocks.HARU_BUTTON.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        fenceBuilder(ModBlocks.HARU_FENCE.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        fenceGateBuilder(ModBlocks.HARU_FENCE_GATE.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        doorBuilder(ModBlocks.HARU_DOOR.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        trapdoorBuilder(ModBlocks.HARU_TRAPDOOR.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        pressurePlate(pRecipeOutput, ModBlocks.HARU_PRESSURE_PLATE.get(), ModBlocks.HARU_PLANKS.get());

        signBuilder(ModBlocks.HARU_SIGN.get(), Ingredient.of(ModBlocks.HARU_PLANKS.get())).group("haru")
                .unlockedBy("has_haru", has(ModBlocks.HARU_PLANKS.get())).save(pRecipeOutput);

        hangingSign(pRecipeOutput, ModBlocks.HARU_HANGING_SIGN.get(), ModBlocks.HARU_PLANKS.get());

        /** COMBAT ------------------------------- */

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_SWORD.get())
                .pattern("E")
                .pattern("E")
                .pattern("S")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_BOW.get())
                .pattern(" ES")
                .pattern("EAS")
                .pattern(" ES")
                .define('E', Items.EMERALD)
                .define('A', Items.BOW)
                .define('S', Items.STRING)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD.get())
                .pattern("E")
                .pattern("E")
                .pattern("S")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CURSED_RUBY_GREATAXE.get())
                .pattern("BSB")
                .pattern("BSB")
                .pattern(" S ")
                .define('B', ModItems.CURSED_RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CURSED_RUBY_BOW.get())
                .pattern(" RB")
                .pattern("RAB")
                .pattern(" RB")
                .define('R', ModItems.CURSED_RUBY.get())
                .define('A', Items.BOW)
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);

        /** ARMOR ------------------------------- */

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_HELMET.get())
                .pattern("EEE")
                .pattern("E E")
                .define('E', Items.EMERALD)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_CHESTPLATE.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', Items.EMERALD)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_LEGGINGS.get())
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .define('E', Items.EMERALD)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_BOOTS.get())
                .pattern("E E")
                .pattern("E E")
                .define('E', Items.EMERALD)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);
        //
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET.get())
                .pattern("EEE")
                .pattern("E E")
                .define('E', ModItems.RUBY)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModItems.RUBY)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS.get())
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .define('E', ModItems.RUBY)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS.get())
                .pattern("E E")
                .pattern("E E")
                .define('E', ModItems.RUBY)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);
        //
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CURSED_RUBY_HELMET.get())
                .pattern("EEE")
                .pattern("E E")
                .define('E', ModItems.CURSED_RUBY)
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CURSED_RUBY_CHESTPLATE.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModItems.CURSED_RUBY)
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CURSED_RUBY_LEGGINGS.get())
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .define('E', ModItems.CURSED_RUBY)
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CURSED_RUBY_BOOTS.get())
                .pattern("E E")
                .pattern("E E")
                .define('E', ModItems.CURSED_RUBY)
                .unlockedBy("has_cursed_ruby", has(ModItems.CURSED_RUBY)).save(pRecipeOutput);

        /** TOOLS ------------------------------- */

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_PICKAXE.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_AXE.get())
                .pattern("EE ")
                .pattern("ES ")
                .pattern(" S ")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_AXE.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput, "distantlandsmc:emerald_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL.get())
                .pattern("E")
                .pattern("S")
                .pattern("S")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_HOE.get())
                .pattern("EE ")
                .pattern(" S ")
                .pattern(" S ")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMERALD_HOE.get())
                .pattern("EE ")
                .pattern(" S ")
                .pattern(" S ")
                .define('E', Items.EMERALD)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald", has(Items.EMERALD)).save(pRecipeOutput, "distantlandsmc:emerald_hoe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE.get())
                .pattern("EE ")
                .pattern("ES ")
                .pattern(" S ")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput, "distantlandsmc:ruby_axe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL.get())
                .pattern("E")
                .pattern("S")
                .pattern("S")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE.get())
                .pattern("EE ")
                .pattern(" S ")
                .pattern(" S ")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE.get())
                .pattern("EE ")
                .pattern(" S ")
                .pattern(" S ")
                .define('E', ModItems.RUBY)
                .define('S', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput, "distantlandsmc:ruby_hoe_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HAMMER.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern(" R ")
                .define('B', ModItems.RUBY.get())
                .define('R', Items.BLAZE_ROD)
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);
    }

    protected static void oreSmelting(@NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, DistantLandsMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
