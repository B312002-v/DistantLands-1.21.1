package net.beastguy.distantlandsmc.payloads;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record CarpenterTableOpenPayload(BlockPos pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<CarpenterTableOpenPayload> ID =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("distantlandsmc", "carpenter_table_open"));

    public static final StreamCodec<ByteBuf, BlockPos> BLOCK_POS = StreamCodec.composite(
            ByteBufCodecs.INT, BlockPos::getX,
            ByteBufCodecs.INT, BlockPos::getY,
            ByteBufCodecs.INT, BlockPos::getZ,
            BlockPos::new
    );

    public static final StreamCodec<ByteBuf, CarpenterTableOpenPayload> CODEC =
            StreamCodec.composite(
                    BLOCK_POS, CarpenterTableOpenPayload::pos,
                    CarpenterTableOpenPayload::new
            );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
