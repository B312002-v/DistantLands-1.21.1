package net.beastguy.distantlandsmc.screen.custom;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.recipe.FilterableRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CarpenterTableScreen extends AbstractContainerScreen<CarpenterTableMenu> {
    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/carpenter_table_stonecutter.png");

    private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller");
    private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller_disabled");
    private static final ResourceLocation RECIPE_SELECTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_selected");
    private static final ResourceLocation RECIPE_HIGHLIGHTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_highlighted");
    private static final ResourceLocation RECIPE_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    private final List<FilterableRecipe> filteredRecipes = new ArrayList<>();
    private int filteredIndex = -1;

    public CarpenterTableScreen(CarpenterTableMenu carpenterTableMenu, Inventory inventory, Component component) {
        super(carpenterTableMenu, inventory, component);
        carpenterTableMenu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void containerTick() {
        super.containerTick();
    }

    private void updateSelectedIndex() {
        filteredIndex = -1;
        int selectedInd = this.menu.getSelectedRecipeIndex();
        var recipes = this.menu.getRecipes();
        if (selectedInd > -1 && selectedInd < recipes.size()) {
            filteredIndex = filteredRecipes.indexOf(recipes.get(selectedInd));
        }
    }

    @Override
    public void resize(@NotNull Minecraft minecraft, int width, int height) {
        this.init(minecraft, width, height);
        this.containerChanged();
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // scrollbar
        int barH = scrollBarHeight();
        int scrollY = minScrollY();
        float barSpan = maxScrollY() - scrollY - barH;
        int barPos = (int) (barSpan * this.scrollOffs);

        ResourceLocation resourceLocation = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
        guiGraphics.blitSprite(resourceLocation, minScrollX(), scrollY + barPos, 12, barH);

        if (!displayRecipes) return;

        // buttons
        forEachButton((index, buttonX, buttonY) -> {
            ResourceLocation buttonTexture;
            if (index == filteredIndex) {
                buttonTexture = RECIPE_SELECTED_SPRITE;
            } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + 16 && mouseY < buttonY + 18) {
                buttonTexture = RECIPE_HIGHLIGHTED_SPRITE;
            } else {
                buttonTexture = RECIPE_SPRITE;
            }
            guiGraphics.blitSprite(buttonTexture, buttonX, buttonY, 16, 18);
        });

        // items
        if (this.minecraft != null && this.minecraft.level != null) {
            forEachButton((index, buttonX, buttonY) -> {
                ItemStack item = filteredRecipes.get(index).recipe().value().getResultItem(this.minecraft.level.registryAccess());
                guiGraphics.renderFakeItem(item, buttonX, buttonY + 1);
                guiGraphics.renderItemDecorations(font, item, buttonX, buttonY + 1);
            });
        }
    }

    @Override
    protected void renderTooltip(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.displayRecipes && this.minecraft != null && this.minecraft.level != null) {
            forEachButton((index, buttonX, buttonY) -> {
                if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                    guiGraphics.renderTooltip(this.font,
                            filteredRecipes.get(index).recipe().value()
                                    .getResultItem(this.minecraft.level.registryAccess()),
                            mouseX, mouseY);
                }
            });
        }
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderLabels(guiGraphics, mouseX, mouseY);
        if (filteredIndex >= 0 && filteredIndex < filteredRecipes.size()) {
            int input = filteredRecipes.get(filteredIndex).recipe().value().getInputCount();
            if (input != 1) {
                String multiplier = input + "x";
                int labelX = this.titleLabelX;
                guiGraphics.drawString(this.font, multiplier, labelX, this.titleLabelY + 37, 4210752, false);
            }
        }
    }

    private int getButtonCount() {
        return getRowCount() * getButtonsPerRow();
    }

    private int getButtonsPerRow() {
        return 4;
    }

    private int getRowCount() {
        return 3;
    }

    private int minScrollX() {
        return this.leftPos + 119;
    }

    private int maxScrollX() {
        return minScrollX() + 12;
    }

    private int minScrollY() {
        return this.topPos + 15;
    }

    private int maxScrollY() {
        return this.topPos + 70;
    }

    private int scrollBarHeight() {
        return 15;
    }

    private void forEachButton(ButtonConsumer buttonConsumer) {
        int buttonBoxX = this.leftPos + 52;
        int buttonBoxY = this.topPos + 13;
        int lastVisibleElementIndex = this.startIndex + getButtonCount();
        int buttonsPerRow = getButtonsPerRow();
        for (int index = this.startIndex; index < lastVisibleElementIndex && index < filteredRecipes.size(); ++index) {
            int visualIndex = index - this.startIndex;
            int buttonX = buttonBoxX + (visualIndex % buttonsPerRow) * 16;
            int buttonY = buttonBoxY + (visualIndex / buttonsPerRow) * 18 + 2;
            buttonConsumer.accept(index, buttonX, buttonY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;

        if (this.displayRecipes) {
            // Proteção contra null em minecraft, player e gameMode
            if (this.minecraft != null && this.minecraft.player != null && this.minecraft.gameMode != null) {
                AtomicReference<Boolean> success = new AtomicReference<>(false);

                forEachButton((index, buttonX, buttonY) -> {
                    if (success.get()) return;
                    int actualIndex = menu.getRecipes().indexOf(filteredRecipes.get(index));
                    if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                        if (this.menu.clickMenuButton(this.minecraft.player, actualIndex)) {
                            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                            this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, actualIndex);
                            updateSelectedIndex();
                        }
                        success.set(true);
                    }
                });

                if (success.get()) return true;
            }

            if (mouseX >= minScrollX() && mouseX < maxScrollX() && mouseY >= minScrollY() && mouseY < maxScrollY()) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int min = minScrollY();
            int max = maxScrollY();
            this.scrollOffs = ((float) mouseY - min - 7.5F) / ((max - min) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int) ((this.scrollOffs * this.getOffscreenRows()) + 0.5) * getButtonsPerRow();
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float f = (float) scrollY / (float) i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) i) + 0.5) * getButtonsPerRow();
        }

        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && filteredRecipes.size() > getButtonCount();
    }

    protected int getOffscreenRows() {
        int buttonsPerRow = getButtonsPerRow();
        return (filteredRecipes.size() + buttonsPerRow - 1) / buttonsPerRow - getRowCount();
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }
        // Atualiza a lista sem filtro
        this.filteredRecipes.clear();
        this.filteredRecipes.addAll(this.menu.getRecipes());
        updateSelectedIndex();
    }

    private interface ButtonConsumer {
        void accept(int index, int buttonX, int buttonY);
    }
}