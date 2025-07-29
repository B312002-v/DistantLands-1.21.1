package net.beastguy.distantlandsmc.util;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.component.ModDataComponentTypes;
import net.beastguy.distantlandsmc.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "on"),
                (pStack, pLevel, pEntity, pSeed) -> pStack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f);

        makeCustomBow(ModItems.EMERALD_BOW.get());
    }

    private static void makeCustomBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float)(p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 6.0F;
            }
        });

        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );
    }
}

