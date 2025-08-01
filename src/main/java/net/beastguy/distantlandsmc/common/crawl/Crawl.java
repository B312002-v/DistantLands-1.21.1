package net.beastguy.distantlandsmc.common.crawl;

import java.util.function.Consumer;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;

public class Crawl {

    public record Payload(boolean crawl) implements CustomPacketPayload {
        public static final CustomPacketPayload.Type<Payload> ID = new CustomPacketPayload.Type<>(Crawl.CRAWL_ID);
        public static final StreamCodec<ByteBuf, Payload> CODEC = ByteBufCodecs.BOOL.map(Payload::new, Payload::crawl);

        @Override
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return ID;
        }
    };

    public static Consumer<Boolean> crawlRequestPacket = null;

    public static final ResourceLocation CRAWL_ID = ResourceLocation.parse("crawl:identifier");

    public static class Shared {
        public static final Pose CRAWLING = Pose.valueOf("CRAWLING");
        public static final EntityDimensions CRAWLING_DIMENSIONS = EntityDimensions.scalable(0.6F, 0.6F).withEyeHeight(0.5F);
        public static final EntityDataAccessor<Boolean> CRAWL_REQUEST = SynchedEntityData.defineId(Player.class, EntityDataSerializers.BOOLEAN);
    }

}
