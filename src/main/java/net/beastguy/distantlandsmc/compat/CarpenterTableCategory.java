package net.beastguy.distantlandsmc.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.recipe.CarpenterTableRecipe;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CarpenterTableCategory implements IRecipeCategory<CarpenterTableRecipe> {
    public static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "carpenter_table");
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/carpenter_table_stonecutter.png");

    public static final RecipeType<CarpenterTableRecipe> CARPENTER_TABLE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, CarpenterTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CarpenterTableCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 168, 77);
        this.icon = helper.createDrawableIngredient(
                VanillaTypes.ITEM_STACK,
                new ItemStack(ModBlocks.CARPENTER_TABLE.get())
        );
    }

    @Override
    public void draw(@NotNull CarpenterTableRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
    }

    @Override
    public @NotNull RecipeType<CarpenterTableRecipe> getRecipeType() {
        return CARPENTER_TABLE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Carpenter Table");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CarpenterTableRecipe recipe, @NotNull IFocusGroup focuses) {
        // Slot de entrada
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 33)
                .addIngredients(recipe.getIngredients().get(0));

        // Slot de saída - agora usa getJEIDisplay() para durabilidade cheia
        builder.addSlot(RecipeIngredientRole.OUTPUT, 143, 33)
                .addItemStack(recipe.getResultItem(null));
    }
}
