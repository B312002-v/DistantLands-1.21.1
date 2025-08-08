package net.beastguy.distantlandsmc;

import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.block.entity.ModBlockEntities;
import net.beastguy.distantlandsmc.block.entity.renderer.PedestalBlockEntityRenderer;
import net.beastguy.distantlandsmc.common.crawl.Crawl;
import net.beastguy.distantlandsmc.component.ModDataComponentTypes;
import net.beastguy.distantlandsmc.effect.ModEffects;
import net.beastguy.distantlandsmc.enchantment.ModEnchantmentEffects;
import net.beastguy.distantlandsmc.entity.ModEntity;
import net.beastguy.distantlandsmc.entity.custom.boat.ModBoatRenderer;
import net.beastguy.distantlandsmc.fluid.BaseFluidType;
import net.beastguy.distantlandsmc.fluid.ModFluidTypes;
import net.beastguy.distantlandsmc.fluid.ModFluids;
import net.beastguy.distantlandsmc.item.ModArmorMaterials;
import net.beastguy.distantlandsmc.item.ModCreativeModeTabs;
import net.beastguy.distantlandsmc.item.ModItems;
import net.beastguy.distantlandsmc.payloads.CarpenterTableOpenPayload;
import net.beastguy.distantlandsmc.payloads.SyncRecipeOrderPayload;
import net.beastguy.distantlandsmc.potion.ModPotions;
import net.beastguy.distantlandsmc.recipe.ModRecipeTypes;
import net.beastguy.distantlandsmc.recipe.RecipeSorter;
import net.beastguy.distantlandsmc.screen.ModMenuTypes;
import net.beastguy.distantlandsmc.screen.custom.CarpenterTableMenu;
import net.beastguy.distantlandsmc.screen.custom.CarpenterTableScreen;
import net.beastguy.distantlandsmc.screen.custom.PedestalScreen;
import net.beastguy.distantlandsmc.sound.ModSounds;
import net.beastguy.distantlandsmc.util.ModItemProperties;
import net.beastguy.distantlandsmc.villager.ModVillagers;
import net.beastguy.distantlandsmc.worldgen.biome.ModBiomes;
import net.beastguy.distantlandsmc.worldgen.biome.ModSurfaceRules;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DistantLandsMod.MODID)
public class DistantLandsMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "distantlandsmc";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation rl(String s)
    {
        return ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, s);
    }

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public DistantLandsMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(DistantLandsMod::registerPacket);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        ModDataComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        ModEntity.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipeTypes.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);


    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PETUNIA.getId(), ModBlocks.POTTED_PETUNIA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HARU_SAPLING.getId(), ModBlocks.POTTED_HARU_SAPLING);

        });

        ModBiomes.registerBiomes();
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeKaupenValleyRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MODID, ModSurfaceRules.makeGlowstonePlainsRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, MODID, ModSurfaceRules.makeEndRotRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makePurplePlainsRules());
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);
        }
    }

    @SuppressWarnings("null")
    public static void registerPacket(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToServer(
                Crawl.Payload.ID,
                Crawl.Payload.CODEC,
                (payload, context) -> {
                    var server = context.player().getServer();
                    if (server != null) {
                        server.execute(() -> context.player().getEntityData().set(Crawl.Shared.CRAWL_REQUEST, payload.crawl()));
                    }
                }
        );
        Crawl.crawlRequestPacket = (wantsToCrawl) -> PacketDistributor.sendToServer(new Crawl.Payload(wantsToCrawl));

        registrar.playToServer(
                CarpenterTableOpenPayload.ID,
                CarpenterTableOpenPayload.CODEC,
                (payload, context) -> {
                    var server = context.player().getServer();
                    if (server == null) return;

                    server.execute(() -> {
                        var player = context.player();
                        var level = player.level();

                        if (level.getBlockState(payload.pos()).getBlock() == ModBlocks.CARPENTER_TABLE.get()) {
                            player.openMenu(new SimpleMenuProvider(
                                    (containerId, inventory, p) -> new CarpenterTableMenu(
                                            containerId,
                                            inventory,
                                            ContainerLevelAccess.create(p.level(), payload.pos()) // <-- cria o ContainerLevelAccess aqui
                                    ),
                                    Component.translatable("container.carpenter_table")
                            ));
                        }
                    });
                }
        );

        // Sincronizar ordem das receitas (server → client)
        registrar.playToClient(
                SyncRecipeOrderPayload.TYPE,
                SyncRecipeOrderPayload.CODEC,
                (payload, context) -> context.enqueueWork(() -> RecipeSorter.acceptOrder(payload.list()))
        );
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntity.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
            EntityRenderers.register(ModEntity.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));

            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BLACK_OPAL_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BLACK_OPAL_WATER.get(), RenderType.translucent());


            });


        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(((BaseFluidType) ModFluidTypes.BLACK_OPAL_WATER_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.BLACK_OPAL_WATER_FLUID_TYPE.get());
        }

        @SubscribeEvent
        public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null &&
                    pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
            event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES);
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);

        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
            event.register(ModMenuTypes.CARPENTER_TABLE_MENU.get(), CarpenterTableScreen::new);

        }

    }
}
