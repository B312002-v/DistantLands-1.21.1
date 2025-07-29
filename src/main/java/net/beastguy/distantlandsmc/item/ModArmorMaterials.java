package net.beastguy.distantlandsmc.item;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, DistantLandsMod.MODID);

    public static final Holder<ArmorMaterial> EMERALD =
            ARMOR_MATERIALS.register("emerald", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Items.EMERALD),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "emerald"))),
                    1.0F, 0.0F));


    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}