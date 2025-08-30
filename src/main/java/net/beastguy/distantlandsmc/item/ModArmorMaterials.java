package net.beastguy.distantlandsmc.item;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, DistantLandsMod.MODID);

    public static final Holder<ArmorMaterial> EMERALD =
            ARMOR_MATERIALS.register("emerald", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Items.EMERALD),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "emerald"))),
                    0.0F, 0.0F));

    public static final Holder<ArmorMaterial> RUBY =
            ARMOR_MATERIALS.register("ruby", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.RUBY),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "ruby"))),
                    2.0F, 0.1F));

    public static final Holder<ArmorMaterial> CURSED_RUBY =
            ARMOR_MATERIALS.register("cursed_ruby", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModItems.CURSED_RUBY),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "cursed_ruby"))),
                    3.0F, 0.3F));


    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}