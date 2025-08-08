package net.beastguy.distantlandsmc.payloads;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.recipe.RecipeSorter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record SyncRecipeOrderPayload(IntList list) implements CustomPacketPayload {

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(DistantLandsMod.MODID, "sync_recipe_order");

    public static final Type<SyncRecipeOrderPayload> TYPE = new Type<>(ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, SyncRecipeOrderPayload> CODEC =
            CustomPacketPayload.codec(
                    SyncRecipeOrderPayload::write,
                    SyncRecipeOrderPayload::read
            );

    private static SyncRecipeOrderPayload read(RegistryFriendlyByteBuf buf) {
        return new SyncRecipeOrderPayload(new IntArrayList(buf.readIntIdList()));
    }

    private void write(RegistryFriendlyByteBuf buf) {
        buf.writeIntIdList(list);
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Chamada no CLIENTE quando o pacote chega
    public static void handle(SyncRecipeOrderPayload payload) {
        RecipeSorter.acceptOrder(payload.list());
    }
}
