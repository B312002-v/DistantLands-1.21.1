package net.beastguy.distantlandsmc.trim;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> RUBY =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "ruby"));
    public static final ResourceKey<TrimMaterial> CURSED_RUBY =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "cursed_ruby"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, RUBY, ModItems.RUBY.get(), Style.EMPTY.withColor(TextColor.parseColor("#bd0013").getOrThrow()), 0.5F);
        register(context, CURSED_RUBY, ModItems.CURSED_RUBY.get(), Style.EMPTY.withColor(TextColor.parseColor("#6d004c").getOrThrow()), 1.0F);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}
