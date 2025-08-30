package net.beastguy.distantlandsmc.common.crawl.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;

public class OptionsScreen extends OptionsSubScreen {

    public OptionsScreen(Screen screen) {
        super(
                screen,
                Minecraft.getInstance().options,
                Component.translatable("crawl.gui.options_title")
        );
    }

    @Override
    protected void addOptions() {
        if (this.list == null) return; // evita NPE

        this.list.addBig(
                OptionInstance.createBoolean(
                        "crawl.config.replace_animation",
                        CrawlClient.replaceAnimation,
                        (value) -> {
                            CrawlClient.replaceAnimation = value;
                            CrawlClient.saveOptions();
                        }
                )
        );
    }

}
