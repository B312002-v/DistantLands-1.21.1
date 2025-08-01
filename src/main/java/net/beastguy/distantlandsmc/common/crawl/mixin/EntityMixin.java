package net.beastguy.distantlandsmc.common.crawl.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.beastguy.distantlandsmc.common.crawl.Crawl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    abstract public Pose getPose();

    @ModifyReturnValue(method = "getBlockJumpFactor", at = @At("RETURN"))
    float getBlockJumpFactor(float jumpFactor) {
        if (this.getPose() == Crawl.Shared.CRAWLING) {
            jumpFactor /= 2.0F;
        }
        return jumpFactor;
    }

    @ModifyReturnValue(method = "isVisuallyCrawling", at = @At("RETURN"))
    private boolean isVisuallyCrawling(boolean original) {
        return original || this.getPose() == Crawl.Shared.CRAWLING;
    }

    @ModifyReturnValue(method = "isSteppingCarefully", at = @At("RETURN"))
    private boolean isSteppingCarefully(boolean original) {
        return original || this.getPose() == Crawl.Shared.CRAWLING;
    }

    @ModifyReturnValue(method = "isDiscrete", at = @At("RETURN"))
    private boolean isDiscrete(boolean original) {
        return original || this.getPose() == Crawl.Shared.CRAWLING;
    }

}