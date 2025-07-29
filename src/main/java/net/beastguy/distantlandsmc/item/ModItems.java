package net.beastguy.distantlandsmc.item;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.entity.custom.boat.ModBoatEntity;
import net.beastguy.distantlandsmc.item.custom.*;
import net.beastguy.distantlandsmc.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DistantLandsMod.MODID);

    /** ORES -------------------------------------------------- */

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item:: new, new Item.Properties());

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CURSED_RUBY = ITEMS.register("cursed_ruby",
            () -> new Item(new Item.Properties()));

    /** FOOD -------------------------------------------------- */

    public static final DeferredItem<Item> TOMATO =
            ITEMS.registerItem("tomato", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.distantlandsmc.tomato.1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.TOMATO));

    /** FUELS -------------------------------------------------- */

    public static final DeferredItem<Item> FROSTFIRE_ICE =
            ITEMS.registerItem("frostfire_ice", properties -> new FuelItem(properties, 800), new Item.Properties());

    /** COMBAT -------------------------------------------------- */

    public static final DeferredItem<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new ModEffectSwordItem(ModToolTiers.EMERALD,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.EMERALD, 3, -2.4f)), MobEffects.GLOWING));

    public static final DeferredItem<Item> EMERALD_BOW = ITEMS.register("emerald_bow",
            () -> new CustomBowItem(new Item.Properties().durability(1530)));

    /** ARMOR -------------------------------------------------- */

    public static final DeferredItem<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(25))));

    public static final DeferredItem<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(25))));

    public static final DeferredItem<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(25))));

    public static final DeferredItem<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(25))));

    public static final DeferredItem<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.EMERALD, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> BEAST_SMITHING_TEMPLATE = ITEMS.register("beast_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "beast")));


    /** TOOLS -------------------------------------------------- */

    public static final DeferredItem<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(Tiers.DIAMOND,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 8f, -3.0f))));


    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.registerItem("chainsaw", ChainsawItem:: new, new Item.Properties().durability(64));


    public static final DeferredItem<Item> BLACK_OPAL_PAXEL = ITEMS.register("black_opal_paxel",
            () -> new PaxelItem(Tiers.DIAMOND,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 1.0f, -2.8f))));


    public static final DeferredItem<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMERALD,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.EMERALD, 1.0f, -2.8f))));

    public static final DeferredItem<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModToolTiers.EMERALD,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.EMERALD, 5.0f, -3.0f))));

    public static final DeferredItem<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModToolTiers.EMERALD,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.EMERALD, 1.5f, -3.0f))));

    public static final DeferredItem<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModToolTiers.EMERALD,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.EMERALD, -3.0f, 0.0f))));

    public static final DeferredItem<Item> RADIATION_STAFF = ITEMS.register("radiation_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    /** ITEMS -------------------------------------------------- */

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final DeferredItem<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.registerItem("bar_brawl_music_disc",
            properties -> new Item(properties.jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> HARU_SIGN = ITEMS.register("haru_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HARU_SIGN.get(), ModBlocks.HARU_WALL_SIGN.get()));
    public static final DeferredItem<Item> HARU_HANGING_SIGN = ITEMS.register("haru_hanging_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HARU_HANGING_SIGN.get(), ModBlocks.HARU_WALL_HANGING_SIGN.get()));

    public static final DeferredItem<Item> HARU_BOAT = ITEMS.register("haru_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.HARU, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HARU_CHEST_BOAT = ITEMS.register("haru_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.HARU, new Item.Properties().stacksTo(1)));

    /** NATURE -------------------------------------------------- */

    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> SMALL_STONE = ITEMS.register("small_stone",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
