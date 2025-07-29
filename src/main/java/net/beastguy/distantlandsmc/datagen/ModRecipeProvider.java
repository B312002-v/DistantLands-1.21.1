package net.beastguy.distantlandsmc.datagen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> BLACK_OPAL_SMELTABLES = List.of(ModItems.RAW_BLACK_OPAL,
                ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE);

        List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.RUBY_DEEPSLATE_ORE);


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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                .unlockedBy("has_black_opal_block", has(ModBlocks.BLACK_OPAL_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get())).save(pRecipeOutput, "distantlandsmc:black_opal_2");

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

        oreSmelting(pRecipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal");
        oreBlasting(pRecipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 100, "black_opal");

        oreSmelting(pRecipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pRecipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");

        oreSmelting(pRecipeOutput, CURSED_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_RUBY.get(), 0.25f, 200, "cursed_ruby");
        oreBlasting(pRecipeOutput, CURSED_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_RUBY.get(), 0.25f, 100, "cursed_ruby");

        /** BUILDING BLOCKS ------------------------------- */

        stairBuilder(ModBlocks.BLACK_OPAL_STAIRS.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                        .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_SLAB.get(), ModItems.BLACK_OPAL.get());

        pressurePlate(pRecipeOutput, ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get(), ModItems.BLACK_OPAL.get());
        buttonBuilder(ModBlocks.BLACK_OPAL_BUTTON.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);

        fenceBuilder(ModBlocks.BLACK_OPAL_FENCE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.BLACK_OPAL_FENCE_GATE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_WALL.get(), ModItems.BLACK_OPAL.get());

        doorBuilder(ModBlocks.BLACK_OPAL_DOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.BLACK_OPAL_TRAPDOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(pRecipeOutput);

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

        stairBuilder(ModBlocks.RUBY_STAIRS.get(), Ingredient.of(ModItems.RUBY)).group("ruby")
                .unlockedBy("has_ruby", has(ModItems.RUBY)).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB.get(), ModItems.RUBY.get());


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

        trimSmithing(pRecipeOutput, ModItems.BEAST_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "beast"));

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
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, DistantLandsMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
