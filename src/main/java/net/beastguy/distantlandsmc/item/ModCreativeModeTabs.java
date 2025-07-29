package net.beastguy.distantlandsmc.item;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DistantLandsMod.MODID);

    public static final Supplier<CreativeModeTab> DISTANT_LANDS_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("distant_lands_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.distantlandsmc.distant_lands_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_OPAL);
                        pOutput.accept(ModItems.RAW_BLACK_OPAL);

                        pOutput.accept(ModItems.RUBY);
                        pOutput.accept(ModItems.CURSED_RUBY);

                        pOutput.accept(ModItems.CHAINSAW);

                        pOutput.accept(ModItems.TOMATO);

                        pOutput.accept(ModItems.FROSTFIRE_ICE);

                        pOutput.accept(ModItems.DATA_TABLET);
                        pOutput.accept(ModItems.METAL_DETECTOR);


                        pOutput.accept(ModItems.TOMATO_SEEDS);

                        pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC);

                        pOutput.accept(ModItems.RADIATION_STAFF);

                        pOutput.accept(ModFluids.BLACK_OPAL_WATER_BUCKET);

                        pOutput.accept(ModItems.HARU_BOAT);
                        pOutput.accept(ModItems.HARU_CHEST_BOAT);

                        pOutput.accept(ModItems.SMALL_STONE);

                    }).build());

    public static final Supplier<CreativeModeTab> DISTANT_LANDS_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("distant_lands_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.distantlandsmc.distant_lands_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "distant_lands_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.BLACK_OPAL_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_END_ORE);

                        pOutput.accept(ModBlocks.MAGIC_BLOCK);

                        pOutput.accept(ModBlocks.BLACK_OPAL_STAIRS);
                        pOutput.accept(ModBlocks.BLACK_OPAL_SLAB);
                        pOutput.accept(ModBlocks.BLACK_OPAL_BUTTON);
                        pOutput.accept(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_FENCE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_FENCE_GATE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_WALL);
                        pOutput.accept(ModBlocks.BLACK_OPAL_DOOR);
                        pOutput.accept(ModBlocks.BLACK_OPAL_TRAPDOOR);

                        pOutput.accept(ModBlocks.BLACK_OPAL_LAMP);

                        pOutput.accept(ModBlocks.RUBY_BLOCK);
                        pOutput.accept(ModBlocks.CURSED_RUBY_BLOCK);
                        pOutput.accept(ModBlocks.RUBY_STAIRS);
                        pOutput.accept(ModBlocks.RUBY_SLAB);

                        pOutput.accept(ModBlocks.RUBY_ORE);
                        pOutput.accept(ModBlocks.RUBY_DEEPSLATE_ORE);
                        pOutput.accept(ModBlocks.NETHER_CURSED_RUBY_ORE);
                        pOutput.accept(ModBlocks.END_CURSED_RUBY_ORE);

                        pOutput.accept(ModBlocks.PETUNIA);
                        pOutput.accept(ModBlocks.COLORED_LEAVES);

                        pOutput.accept(ModBlocks.PEDESTAL);

                        pOutput.accept(ModBlocks.CRYSTALLIZER);

                        pOutput.accept(ModBlocks.HARU_LOG.get());
                        pOutput.accept(ModBlocks.HARU_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_HARU_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_HARU_WOOD.get());
                        pOutput.accept(ModBlocks.HARU_PLANKS.get());
                        pOutput.accept(ModBlocks.HARU_SAPLING.get());

                        pOutput.accept(ModBlocks.HARU_STAIRS.get());
                        pOutput.accept(ModBlocks.HARU_SLAB.get());
                        pOutput.accept(ModBlocks.HARU_BUTTON.get());
                        pOutput.accept(ModBlocks.HARU_FENCE.get());
                        pOutput.accept(ModBlocks.HARU_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.HARU_DOOR.get());
                        pOutput.accept(ModBlocks.HARU_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.HARU_PRESSURE_PLATE.get());

                        pOutput.accept(ModItems.HARU_SIGN.get());
                        pOutput.accept(ModItems.HARU_HANGING_SIGN.get());

                        pOutput.accept(ModBlocks.HARU_LEAVES.get());

                        pOutput.accept(ModBlocks.STICK_GROUND.get());
                        pOutput.accept(ModBlocks.PABBLE.get());
                        pOutput.accept(ModBlocks.PABBLE_1.get());
                        pOutput.accept(ModBlocks.PABBLE_2.get());
                        pOutput.accept(ModBlocks.ROCK.get());

                    }).build());

    public static final Supplier<CreativeModeTab> DISTANT_LANDS_COMBAT_TAB =
            CREATIVE_MODE_TABS.register("distant_lands_combat_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.distantlandsmc.distant_lands_combat_tab"))
                    .icon(() -> new ItemStack(ModItems.EMERALD_SWORD.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "distant_lands_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.EMERALD_HELMET);
                        pOutput.accept(ModItems.EMERALD_CHESTPLATE);
                        pOutput.accept(ModItems.EMERALD_LEGGINGS);
                        pOutput.accept(ModItems.EMERALD_BOOTS);
                        pOutput.accept(ModItems.EMERALD_HORSE_ARMOR);
                        pOutput.accept(ModItems.BEAST_SMITHING_TEMPLATE);
                        pOutput.accept(ModItems.EMERALD_SWORD);
                        pOutput.accept(ModItems.EMERALD_PICKAXE);
                        pOutput.accept(ModItems.EMERALD_AXE);
                        pOutput.accept(ModItems.EMERALD_SHOVEL);
                        pOutput.accept(ModItems.EMERALD_HOE);

                        pOutput.accept(ModItems.BLACK_OPAL_PAXEL);
                        pOutput.accept(ModItems.RUBY_HAMMER);
                        pOutput.accept(ModItems.EMERALD_BOW);



                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
