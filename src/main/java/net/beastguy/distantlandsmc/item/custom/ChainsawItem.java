package net.beastguy.distantlandsmc.item.custom;

import net.beastguy.distantlandsmc.component.ModDataComponentTypes;
import net.beastguy.distantlandsmc.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ChainsawItem extends Item {
    public ChainsawItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();

        if (!level.isClientSide()) {
            if (level.getBlockState(context.getClickedPos()).is(BlockTags.LOGS)) {
                level.destroyBlock(context.getClickedPos(), true, context.getPlayer());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                context.getItemInHand().set(ModDataComponentTypes.COORDINATES, context.getClickedPos());

                if (context.getPlayer() != null) {
                    context.getLevel().playSound(
                            null,
                            context.getPlayer().blockPosition(),
                            ModSounds.CHAINSAW_CUT.get(),
                            SoundSource.PLAYERS,
                            1f, 1f
                    );
                }

                // Server Particles (Via Server, Seen by all players)
                ((ServerLevel) context.getLevel()).sendParticles(ParticleTypes.SMOKE, context.getClickedPos().getX() + 0.5f, context.getClickedPos().getY() + 1.0f,
                        context.getClickedPos().getZ() + 0.5f, 25, 0.0, 0.05, 0.0, 0.15f);
            } else {
                if (context.getPlayer() != null) {
                    context.getLevel().playSound(
                            null,
                            context.getPlayer().blockPosition(),
                            ModSounds.CHAINSAW_PULL.get(),
                            SoundSource.PLAYERS,
                            1f, 1f
                    );
                }
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.distantlandsmc.chainsaw.tooltip.1"));
            tooltipComponents.add(Component.translatable("tooltip.distantlandsmc.chainsaw.tooltip.2"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.distantlandsmc.chainsaw.tooltip.shift"));
        }

        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("Last Tree was chopped at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
