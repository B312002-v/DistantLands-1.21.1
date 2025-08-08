package net.beastguy.distantlandsmc.recipe;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.beastguy.distantlandsmc.payloads.SyncRecipeOrderPayload;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class RecipeSorter {

    private static final List<Item> ITEM_ORDER = new ArrayList<>();
    private static final Set<Item> UNSORTED = new HashSet<>();

    // Chamada no servidor quando pegamos as receitas
    public static void accept(List<RecipeHolder<CarpenterTableRecipe>> recipes) {
        UNSORTED.clear();
        recipes.forEach(r ->
                UNSORTED.add(r.value().getResultItem(RegistryAccess.EMPTY).getItem())
        );
    }

    // Chamada no cliente quando recebemos a ordem do servidor
    public static void acceptOrder(IntList list) {
        UNSORTED.clear();
        ITEM_ORDER.clear();
        list.forEach(i -> ITEM_ORDER.add(BuiltInRegistries.ITEM.byId(i)));
    }

    // Recalcula a ordem com base nas abas do criativo
    public static void refreshIfNeeded(RegistryAccess reg) {
        if (UNSORTED.isEmpty()) return;

        ITEM_ORDER.clear();

        // Reconstruir abas se estiverem vazias
        if (!CreativeModeTabs.getDefaultTab().hasAnyItems()) {
            CreativeModeTabs.tryRebuildTabContents(FeatureFlags.VANILLA_SET, false, reg);
        }

        for (var tab : CreativeModeTabs.tabs()) {
            if (UNSORTED.isEmpty()) break;

            List<Item> found = new ArrayList<>();
            var tabItems = tab.getDisplayItems().stream().map(ItemStack::getItem).toList();

            for (Item item : tabItems) {
                if (UNSORTED.contains(item)) {
                    found.add(item);
                    UNSORTED.remove(item);
                }
            }
            ITEM_ORDER.addAll(found);
        }

        UNSORTED.clear();
    }

    // Versão auxiliar para refresh sem player (usa ServerLifecycleHooks)
    private static void refreshIfNeededNoPlayer() {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) {
            refreshIfNeeded(server.registryAccess());
        }
    }

    // Ordena as receitas no servidor/cliente
    public static void sort(List<RecipeHolder<CarpenterTableRecipe>> recipes, Level level) {
        refreshIfNeeded(level.registryAccess());
        recipes.sort(Comparator.comparingInt(r ->
                ITEM_ORDER.indexOf(r.value().getResultItem(RegistryAccess.EMPTY).getItem())
        ));
    }

    // Envia a ordem para um jogador específico ou para todos
    public static void sendOrderToClient(@Nullable ServerPlayer player) {
        if (player != null) {
            refreshIfNeeded(player.level().registryAccess());
        } else {
            refreshIfNeededNoPlayer();
        }

        IntList list = new IntArrayList();
        ITEM_ORDER.forEach(i -> list.add(BuiltInRegistries.ITEM.getId(i)));

        SyncRecipeOrderPayload payload = new SyncRecipeOrderPayload(list);

        if (player != null) {
            // Envia apenas para o jogador especificado
            player.connection.send(payload);
        } else {
            // Envia para todos os jogadores conectados
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                for (ServerPlayer p : server.getPlayerList().getPlayers()) {
                    p.connection.send(payload);
                }
            }
        }
    }
}
