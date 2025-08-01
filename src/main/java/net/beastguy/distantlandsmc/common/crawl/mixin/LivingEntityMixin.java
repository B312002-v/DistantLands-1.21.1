package net.beastguy.distantlandsmc.common.crawl.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.beastguy.distantlandsmc.common.crawl.Crawl.Shared;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends net.minecraft.world.entity.Entity {

    LivingEntityMixin() { super(null, null); }

    @ModifyExpressionValue(
            method = "updateSwimAmount",
            at = @At(
                    value = "INVOKE",
                    target = "net/minecraft/world/entity/LivingEntity.isVisuallySwimming()Z"
            )
    )
    boolean updateSwimAmount(boolean isInSwimmingPose) {
        return isInSwimmingPose || this.getPose() == Shared.CRAWLING;
    }

}
