    package net.beastguy.distantlandsmc.screen.custom;

    import net.beastguy.distantlandsmc.DistantLandsMod;
    import net.beastguy.distantlandsmc.recipe.FilterableRecipe;
    import net.beastguy.distantlandsmc.recipe.RecipeSorter;
    import net.minecraft.client.Minecraft;
    import net.minecraft.client.gui.GuiGraphics;
    import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
    import net.minecraft.client.resources.sounds.SimpleSoundInstance;
    import net.minecraft.network.chat.Component;
    import net.minecraft.resources.ResourceLocation;
    import net.minecraft.sounds.SoundEvents;
    import net.minecraft.tags.TagKey;
    import net.minecraft.util.Mth;
    import net.minecraft.world.entity.player.Inventory;
    import net.minecraft.world.item.ItemStack;
    import org.jetbrains.annotations.NotNull;
    import net.minecraft.client.gui.components.EditBox;
    import net.minecraft.client.gui.Font;

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

        private static final ResourceLocation HOLLOW_BUTTON = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/hollow_button.png");
        private static final ResourceLocation BLOCKS_BUTTON = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/blocks_button.png");
        private static final ResourceLocation TOOLS_BUTTON = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/tools_button.png");
        private static final ResourceLocation MISC_BUTTON = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/misc_button.png");
        private static final ResourceLocation RESET_BUTTON = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "textures/gui/carpenter_table/reset_button.png");

        private float scrollOffs;
        private boolean scrolling;
        private int startIndex;
        private boolean displayRecipes;

        private EditBox searchBox;

        private String lastSearchText = "";

        private final List<FilterableRecipe> filteredRecipes = new ArrayList<>();
        private int filteredIndex = -1;

        private static final int CATEGORY_BUTTON_WIDTH = 10;
        private static final int CATEGORY_BUTTON_HEIGHT = 10;

        private final List<CategoryButton> categoryButtons = new ArrayList<>();

        private FilterableRecipe selectedRecipe = null;

        public CarpenterTableScreen(CarpenterTableMenu carpenterTableMenu, Inventory inventory, Component component) {
            super(carpenterTableMenu, inventory, component);
            carpenterTableMenu.registerUpdateListener(this::containerChanged);
            --this.titleLabelY;
        }

        @Override
        protected void init() {
            super.init();

            Font font = this.font;

            // SearchBox
            int searchX = this.leftPos + 95;
            int searchY = this.topPos + 2;
            this.searchBox = new EditBox(font, searchX, searchY, 75, 12, Component.translatable("gui.recipe_search"));
            this.searchBox.setBordered(true);
            this.searchBox.setMaxLength(50);
            this.searchBox.setResponder(text -> {
                this.menu.setTextFilter(text);
                this.filteredRecipes.clear();
                this.filteredRecipes.addAll(this.menu.getFilteredRecipes());
                updateSelectedRecipe();
                if (!text.equals(lastSearchText)) {
                    this.scrollOffs = 0.0F;
                    this.startIndex = 0;
                }
                lastSearchText = text;
                this.displayRecipes = this.menu.hasInputItem();
            });
            this.addRenderableWidget(this.searchBox);

            // Grid de botões
            int buttonX = this.leftPos + 135;
            int buttonY = this.topPos + 57;
            int spacing = CATEGORY_BUTTON_WIDTH + 2;

            categoryButtons.clear();
            categoryButtons.add(new CategoryButton(HOLLOW_BUTTON, RecipeSorter.HOLLOW_BUTTON_TAGS, buttonX, buttonY));               // topo esquerda
            categoryButtons.add(new CategoryButton(BLOCKS_BUTTON, RecipeSorter.BLOCKS_BUTTON_TAGS, buttonX + spacing, buttonY));       // topo direita
            categoryButtons.add(new CategoryButton(TOOLS_BUTTON, RecipeSorter.TOOLS_BUTTON_TAGS, buttonX, buttonY + spacing));        // baixo esquerda
            categoryButtons.add(new CategoryButton(MISC_BUTTON, RecipeSorter.MISC_BUTTON_TAGS, buttonX + spacing, buttonY + spacing)); // baixo direita

            // Botão RESET na mesma “grid” mas deslocado ao lado
            int resetX = buttonX + spacing * 2;         // deslocado à direita da grid
            int resetY = buttonY + spacing / 2;         // centralizado verticalmente
            categoryButtons.add(new CategoryButton(RESET_BUTTON, RecipeSorter.RESET_BUTTON_TAGS, resetX, resetY));
        }

        @Override
        protected void containerTick() {
            super.containerTick();
        }


        private void updateSelectedRecipe() {
            int selectedInd = this.menu.getSelectedRecipeIndex();
            if (selectedInd > -1 && selectedInd < filteredRecipes.size()) {
                selectedRecipe = filteredRecipes.get(selectedInd);
                filteredIndex = selectedInd;
            } else {
                selectedRecipe = null;
                filteredIndex = -1;
            }
        }

        @Override
        public void resize(@NotNull Minecraft minecraft, int width, int height) {
            this.init(minecraft, width, height);
            this.containerChanged();
        }

        @Override
        public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            this.renderBackground(guiGraphics, mouseX, mouseY, partialTick); // renderiza fundo
            super.render(guiGraphics, mouseX, mouseY, partialTick); // renderiza slots, itens etc.
            this.searchBox.render(guiGraphics, mouseX, mouseY, partialTick); // searchBox na frente

            // Placeholder "Search" quando a box estiver vazia e sem foco
            if (!this.searchBox.isFocused() && this.searchBox.getValue().isEmpty()) {
                int color = 0xFF555555; // cinza escuro
                guiGraphics.drawString(this.font, "Search", this.searchBox.getX() + 3, this.searchBox.getY() + 2, color, false);
            }

            this.renderTooltip(guiGraphics, mouseX, mouseY); // tooltips
        }

        @Override
        protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
            // Fundo
            guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

            // Scrollbar
            int barH = scrollBarHeight();
            int scrollY = minScrollY();
            float barSpan = maxScrollY() - scrollY - barH;
            int barPos = (int) (barSpan * this.scrollOffs);

            ResourceLocation scrollSprite = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
            guiGraphics.blitSprite(scrollSprite, minScrollX(), scrollY + barPos, 12, barH);

            for (CategoryButton button : categoryButtons) {
                int texWidth = CATEGORY_BUTTON_WIDTH;
                int texHeight = CATEGORY_BUTTON_HEIGHT;
                int fullTexWidth = texWidth;
                int fullTexHeight = texHeight * 2;
                int yOffset = 0;

                int drawX = button.x;
                int drawY = button.y;

                if (button.texture.equals(RESET_BUTTON)) {
                    // largura e altura do botão no GUI

                    // tamanho total da textura (11x24), mas só usamos a metade superior
                    fullTexWidth = 11;
                    fullTexHeight = 24;

                    // sempre usa a metade superior (normal)

                    // centraliza a textura dentro do botão
                } else {
                    // lógica dos outros botões com selected
                    for (TagKey<?> tag : button.tags) {
                        if (this.menu.getCurrentCategoryTags().contains(tag)) {
                            yOffset = texHeight;
                            break;
                        }
                    }
                }

                guiGraphics.blit(
                        button.texture,
                        drawX, drawY,
                        0, yOffset,
                        texWidth, texHeight,
                        fullTexWidth, fullTexHeight
                );
            }

            // Só renderiza receitas se tiver item
            if (!displayRecipes) return;

            // recipe buttons
            forEachButton((index, buttonX, buttonY) -> {
                ResourceLocation buttonTexture;
                FilterableRecipe recipe = filteredRecipes.get(index);
                if (recipe.equals(selectedRecipe)) {
                    buttonTexture = RECIPE_SELECTED_SPRITE;
                } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + 16 && mouseY < buttonY + 18) {
                    buttonTexture = RECIPE_HIGHLIGHTED_SPRITE;
                } else {
                    buttonTexture = RECIPE_SPRITE;
                }
                guiGraphics.blitSprite(buttonTexture, buttonX, buttonY, 16, 18);
            });

            // recipe items
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

            // Clique no searchBox
            if (this.searchBox.mouseClicked(mouseX, mouseY, button)) {
                this.setFocused(this.searchBox);
                return true;
            } else if (this.searchBox.isFocused()) {
                this.searchBox.setFocused(false);
                this.setFocused(null);
            }

            // Clique esquerdo
            if (button == 0) {

                // 🔹 Botões de categoria
                for (CategoryButton catButton : categoryButtons) {
                    if (catButton.isHovered(mouseX, mouseY)) {
                        if (catButton.tags == RecipeSorter.RESET_BUTTON_TAGS) {
                            this.menu.setCategoryTags(List.of());
                        } else {
                            this.menu.setCategoryTags(catButton.tags);
                        }

                        // Atualiza a lista filtrada na screen
                        this.filteredRecipes.clear();
                        this.filteredRecipes.addAll(this.menu.getFilteredRecipes());
                        updateSelectedRecipe();

                        // Reseta scroll
                        this.startIndex = 0;
                        this.scrollOffs = 0.0F;

                        return true;
                    }
                }

                // 🔹 Clique nas receitas filtradas
                if (this.displayRecipes && this.minecraft != null && this.minecraft.player != null && this.minecraft.gameMode != null) {
                    AtomicReference<Boolean> success = new AtomicReference<>(false);

                    forEachButton((index, buttonX, buttonY) -> {
                        if (success.get()) return;

                        if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                            // Atualiza preview com a receita filtrada clicada
                            selectedRecipe = filteredRecipes.get(index);
                            filteredIndex = index;

                            // Envia clique ao menu para atualizar slot de resultado
                            this.menu.clickMenuButton(this.minecraft.player, index);

                            // Som de clique
                            Minecraft.getInstance().getSoundManager()
                                    .play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));

                            success.set(true);
                        }
                    });

                    if (success.get()) return true;
                }
            }

            // Scrollbar
            if (mouseX >= minScrollX() && mouseX < maxScrollX() && mouseY >= minScrollY() && mouseY < maxScrollY()) {
                this.scrolling = true;
                return true;
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

        @Override
        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            // Se o searchBox estiver focado
            if (this.searchBox.isFocused()) {
                // Se ESC for pressionado, remove foco
                if (keyCode == 256) { // ESC
                    this.searchBox.setFocused(false);
                    this.setFocused(null); // devolve foco ao menu
                    return true;
                }

                // Processa a tecla no EditBox
                if (this.searchBox.keyPressed(keyCode, scanCode, modifiers)) {
                    return true;
                }

                // Bloqueia tecla de inventário enquanto digitando
                int inventoryKey = Minecraft.getInstance().options.keyInventory.getKey().getValue();
                if (keyCode == inventoryKey) {
                    return true;
                }
            }

            return super.keyPressed(keyCode, scanCode, modifiers);
        }

        @Override
        public boolean charTyped(char codePoint, int modifiers) {
            // Se o searchBox estiver focado, processa o input de caracteres
            if (this.searchBox.isFocused() && this.searchBox.charTyped(codePoint, modifiers)) {
                return true;
            }
            return super.charTyped(codePoint, modifiers);
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
            this.filteredRecipes.clear();
            this.filteredRecipes.addAll(this.menu.getFilteredRecipes());

            // 🔹 Mantém selectedRecipe apenas se ainda estiver na lista filtrada
            if (selectedRecipe != null && filteredRecipes.contains(selectedRecipe)) {
                filteredIndex = filteredRecipes.indexOf(selectedRecipe);
            } else {
                selectedRecipe = null;
                filteredIndex = -1;
            }

            // 🔹 Reseta scroll se não houver item de input
            if (!this.displayRecipes) {
                this.scrollOffs = 0.0F;
                this.startIndex = 0;
            }
        }

        private interface ButtonConsumer {
            void accept(int index, int buttonX, int buttonY);
        }

        private record CategoryButton(ResourceLocation texture, List<TagKey<?>> tags, int x, int y) {

            public boolean isHovered(double mouseX, double mouseY) {
                    return mouseX >= x && mouseX < x + CATEGORY_BUTTON_WIDTH &&
                            mouseY >= y && mouseY < y + CATEGORY_BUTTON_HEIGHT;
                }
            }
    }