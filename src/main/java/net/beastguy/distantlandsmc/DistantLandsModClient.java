package net.beastguy.distantlandsmc;

import net.beastguy.distantlandsmc.common.crawl.client.CrawlClient;
import net.beastguy.distantlandsmc.common.crawl.client.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = DistantLandsMod.MODID, dist = Dist.CLIENT)
public class DistantLandsModClient {

    public DistantLandsModClient(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerExtensionPoint(
                IConfigScreenFactory.class,
                (ModContainer mod, Screen parentScreen) -> {
                    return new OptionsScreen(parentScreen);
                }
        );
        modEventBus.addListener(DistantLandsModClient::registerBindings);
    }

    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(CrawlClient.key);
    }

}
