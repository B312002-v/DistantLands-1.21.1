package net.beastguy.distantlandsmc.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CarpenterTableScreen extends AbstractContainerScreen<CarpenterTableMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID,"textures/gui/carpenter_table/carpenter_table_gui.png");

    private static final int RECIPES_PER_ROW = 5;
    private static final int RECIPE_ICON_SIZE = 18;
    private static final int RECIPE_ICON_PADDING = 2;
    private static final int RECIPE_START_X = 8;
    private static final int RECIPE_START_Y = 6;

    public CarpenterTableScreen(CarpenterTableMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // Renderizar ícones das receitas
        var recipes = menu.getAvailableRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            int row = i / RECIPES_PER_ROW;
            int col = i % RECIPES_PER_ROW;
            int iconX = leftPos + RECIPE_START_X + col * (RECIPE_ICON_SIZE + RECIPE_ICON_PADDING);
            int iconY = topPos + RECIPE_START_Y + row * (RECIPE_ICON_SIZE + RECIPE_ICON_PADDING);

            ItemStack output = recipes.get(i).value().output();

            // Fundo do botão (cinza claro)
            guiGraphics.fill(iconX - 1, iconY - 1, iconX + RECIPE_ICON_SIZE, iconY + RECIPE_ICON_SIZE, 0xFFAAAAAA);

            // Destaque para o selecionado (verde)
            if (i == menu.getSelectedRecipeIndex()) {
                guiGraphics.fill(iconX - 1, iconY - 1, iconX + RECIPE_ICON_SIZE, iconY + RECIPE_ICON_SIZE, 0xFF00FF00);
            }

            guiGraphics.renderItem(output, iconX, iconY);
            guiGraphics.renderItemDecorations(font, output, iconX, iconY);
        }
    }


    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);

        // Tooltips das receitas
        int baseX = leftPos + RECIPE_START_X;
        int baseY = topPos + RECIPE_START_Y;

        var recipes = menu.getAvailableRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            int row = i / RECIPES_PER_ROW;
            int col = i % RECIPES_PER_ROW;
            int iconX = baseX + col * (RECIPE_ICON_SIZE + RECIPE_ICON_PADDING);
            int iconY = baseY + row * (RECIPE_ICON_SIZE + RECIPE_ICON_PADDING);

        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int baseX = leftPos + RECIPE_START_X;
        int baseY = topPos + RECIPE_START_Y;

        var recipes = menu.getAvailableRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            int row = i / RECIPES_PER_ROW;
            int col = i % RECIPES_PER_ROW;
            int iconX = baseX + col * (RECIPE_ICON_SIZE + RECIPE_ICON_PADDING);
            int iconY = baseY + row * (RECIPE_ICON_SIZE + RECIPE_ICON_PADDING);

            if (mouseX >= iconX && mouseX <= iconX + RECIPE_ICON_SIZE &&
                    mouseY >= iconY && mouseY <= iconY + RECIPE_ICON_SIZE) {

                if (minecraft != null && minecraft.player != null) {
                    menu.clickMenuButton(minecraft.player, i);
                }

                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }
}