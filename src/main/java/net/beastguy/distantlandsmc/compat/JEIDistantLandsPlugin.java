package net.beastguy.distantlandsmc.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.recipe.CarpenterTableRecipe;
import net.beastguy.distantlandsmc.recipe.ModRecipeTypes;
import net.beastguy.distantlandsmc.screen.custom.CarpenterTableScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class JEIDistantLandsPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CarpenterTableCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level != null) {
            RecipeManager recipeManager = mc.level.getRecipeManager();

            List<CarpenterTableRecipe> carpenterTableRecipes = recipeManager
                    .getAllRecipesFor(ModRecipeTypes.CARPENTER_TABLE_TYPE.get()).stream()
                    .map(RecipeHolder::value)
                    .toList();

            registration.addRecipes(
                    CarpenterTableCategory.CARPENTER_TABLE_RECIPE_RECIPE_TYPE,
                    carpenterTableRecipes
            );
        }
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CarpenterTableScreen.class, 70, 30, 25, 20,
                CarpenterTableCategory.CARPENTER_TABLE_RECIPE_RECIPE_TYPE);
    }

}
