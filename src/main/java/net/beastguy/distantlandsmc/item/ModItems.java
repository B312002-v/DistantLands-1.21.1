package net.beastguy.distantlandsmc.item;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.entity.custom.boat.ModBoatEntity;
import net.beastguy.distantlandsmc.item.custom.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DistantLandsMod.MODID);

    /** ORES -------------------------------------------------- */

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CURSED_RUBY = ITEMS.register("cursed_ruby",
            () -> new Item(new Item.Properties()));

    /** FOOD -------------------------------------------------- */


    /** FUELS -------------------------------------------------- */


    /** COMBAT -------------------------------------------------- */

    public static final DeferredItem<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new ModEffectSwordItem(ModToolTiers.EMERALD,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.EMERALD, 3, -2.4f)), MobEffects.GLOWING));

    public static final DeferredItem<Item> EMERALD_BOW = ITEMS.register("emerald_bow",
            () -> new CustomEmeraldBowItem(new Item.Properties().durability(1530)));

    public static final DeferredItem<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 3, -2.4F))));

    public static final DeferredItem<SwordItem> CURSED_RUBY_GREATAXE = ITEMS.register("cursed_ruby_greataxe",
            () -> new SwordItem(ModToolTiers.CURSED_RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CURSED_RUBY, 13.5F, -2.4F))));


    public static final DeferredItem<Item> CURSED_RUBY_BOW = ITEMS.register("cursed_ruby_bow",
            () -> new CustomBowItem(new Item.Properties().durability(2030)));

    /** ARMOR -------------------------------------------------- */

    public static final DeferredItem<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))));

    public static final DeferredItem<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33))));

    public static final DeferredItem<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33))));

    public static final DeferredItem<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))));

    public static final DeferredItem<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.EMERALD, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));


    public static final DeferredItem<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))));

    public static final DeferredItem<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))));

    public static final DeferredItem<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35))));

    public static final DeferredItem<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))));

    public static final DeferredItem<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.RUBY, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> CURSED_RUBY_HELMET = ITEMS.register("cursed_ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CURSED_RUBY, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));

    public static final DeferredItem<Item> CURSED_RUBY_CHESTPLATE = ITEMS.register("cursed_ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CURSED_RUBY, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));

    public static final DeferredItem<Item> CURSED_RUBY_LEGGINGS = ITEMS.register("cursed_ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.CURSED_RUBY, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));

    public static final DeferredItem<Item> CURSED_RUBY_BOOTS = ITEMS.register("cursed_ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.CURSED_RUBY, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))));



    /** TOOLS -------------------------------------------------- */

    public static final DeferredItem<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(Tiers.DIAMOND,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 8f, -3.0f))));


    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.registerItem("chainsaw", ChainsawItem:: new, new Item.Properties().durability(64));



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


    public static final DeferredItem<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.RUBY, 1.0F, -2.8F))));

    public static final DeferredItem<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.RUBY, 5.0F, -3.0F))));

    public static final DeferredItem<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.RUBY, 1.5F, -3.0f))));

    public static final DeferredItem<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.RUBY, 0.5F, 0.0f))));

    /** ITEMS -------------------------------------------------- */

    public static final DeferredItem<Item> HARU_SIGN = ITEMS.register("haru_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HARU_SIGN.get(), ModBlocks.HARU_WALL_SIGN.get()));
    public static final DeferredItem<Item> HARU_HANGING_SIGN = ITEMS.register("haru_hanging_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HARU_HANGING_SIGN.get(), ModBlocks.HARU_WALL_HANGING_SIGN.get()));

    public static final DeferredItem<Item> HARU_BOAT = ITEMS.register("haru_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.HARU, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HARU_CHEST_BOAT = ITEMS.register("haru_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.HARU, new Item.Properties().stacksTo(1)));

    /** NATURE -------------------------------------------------- */

    public static final DeferredItem<Item> SMALL_STONE = ITEMS.register("small_stone",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
