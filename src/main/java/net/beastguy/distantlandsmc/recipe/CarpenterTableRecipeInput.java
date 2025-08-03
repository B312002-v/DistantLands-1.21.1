package net.beastguy.distantlandsmc.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

public record CarpenterTableRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public @NotNull ItemStack getItem(int i) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}