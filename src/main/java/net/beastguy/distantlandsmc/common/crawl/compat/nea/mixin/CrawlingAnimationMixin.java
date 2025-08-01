package net.beastguy.distantlandsmc.common.crawl.compat.nea.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.tr7zw.notenoughanimations.animations.fullbody.CrawlingAnimation;
import net.beastguy.distantlandsmc.common.crawl.Crawl;
import net.beastguy.distantlandsmc.common.crawl.client.CrawlClient;
import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = CrawlingAnimation.class, remap = false)
public class CrawlingAnimationMixin {

	@ModifyReturnValue(method = "isValid", at = @At("RETURN"), remap = false)
	boolean isValid(boolean original, @Local(argsOnly = true) AbstractClientPlayer entity) {
		return (original || entity.hasPose(Crawl.Shared.CRAWLING)) && !CrawlClient.replaceAnimation;
	}

}
