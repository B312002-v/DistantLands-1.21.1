package net.beastguy.distantlandsmc.recipe;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.Locale;

public record FilterableRecipe(RecipeHolder<CarpenterTableRecipe> recipe, ItemStack output) {

    public static FilterableRecipe of(RecipeHolder<CarpenterTableRecipe> recipe) {
        return new FilterableRecipe(recipe, recipe.value().getResultItem(RegistryAccess.EMPTY));
    }

    public boolean matchFilter(String filter) {
        return output.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter);
    }


}
