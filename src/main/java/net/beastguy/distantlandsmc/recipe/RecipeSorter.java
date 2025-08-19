package net.beastguy.distantlandsmc.recipe;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.beastguy.distantlandsmc.payloads.SyncRecipeOrderPayload;
import net.beastguy.distantlandsmc.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class RecipeSorter {

    private static final List<Item> ITEM_ORDER = new ArrayList<>();
    private static final Set<Item> ALL_ITEMS = new HashSet<>();
    private static final Map<RecipeHolder<CarpenterTableRecipe>, Integer> recipeIndices = new HashMap<>();

    // Tags separadas por categoria de botão
    public static final List<TagKey<?>> HOLLOW_BUTTON_TAGS = List.of(
            ModTags.Blocks.HOLLOW_LOGS,
            ModTags.Blocks.STRIPPED_HOLLOW_LOGS
    );

    public static final List<TagKey<?>> BLOCKS_BUTTON_TAGS = List.of(
            ModTags.Blocks.WOOD,
            ModTags.Blocks.STRIPPED_LOG,
            ModTags.Blocks.STRIPPED_WOOD,
            ModTags.Blocks.PLANKS,
            ModTags.Blocks.STAIRS,
            ModTags.Blocks.SLAB,
            ModTags.Blocks.FENCE,
            ModTags.Blocks.FENCE_GATE,
            ModTags.Blocks.DOOR,
            ModTags.Blocks.TRAPDOOR,
            ModTags.Blocks.PRESSURE_PLATE,
            ModTags.Blocks.BUTTON,
            ModTags.Blocks.SIGN
    );

    public static final List<TagKey<?>> TOOLS_BUTTON_TAGS = List.of(
            ModTags.Items.STICK,
            ModTags.Items.WOODEN_SWORD,
            ModTags.Items.WOODEN_PICKAXE,
            ModTags.Items.WOODEN_AXE,
            ModTags.Items.WOODEN_SHOVEL,
            ModTags.Items.WOODEN_HOE
    );

    public static final List<TagKey<?>> MISC_BUTTON_TAGS = List.of(
            ModTags.Blocks.CHISELED_BOOKSHELF,
            ModTags.Blocks.CHEST,
            ModTags.Blocks.BARREL,
            ModTags.Blocks.LADDER,
            ModTags.Items.BOWL,
            ModTags.Items.BOAT,
            ModTags.Items.CHEST_BOAT
    );

    // Lista única com a ordem exata de tags
    private static final List<TagKey<?>> ORDERED_TAGS = List.of(
            ModTags.Blocks.WOOD,
            ModTags.Blocks.STRIPPED_LOG,
            ModTags.Blocks.STRIPPED_WOOD,
            ModTags.Blocks.PLANKS,
            ModTags.Blocks.STAIRS,
            ModTags.Blocks.SLAB,
            ModTags.Blocks.FENCE,
            ModTags.Blocks.FENCE_GATE,
            ModTags.Blocks.DOOR,
            ModTags.Blocks.TRAPDOOR,
            ModTags.Blocks.PRESSURE_PLATE,
            ModTags.Blocks.BUTTON,
            ModTags.Blocks.SIGN,
            ModTags.Blocks.CHISELED_BOOKSHELF,
            ModTags.Blocks.CHEST,
            ModTags.Blocks.BARREL,
            ModTags.Blocks.LADDER,
            ModTags.Items.BOWL,
            ModTags.Items.STICK,
            ModTags.Items.BOAT,
            ModTags.Items.CHEST_BOAT,
            ModTags.Items.WOODEN_SWORD,
            ModTags.Items.WOODEN_PICKAXE,
            ModTags.Items.WOODEN_AXE,
            ModTags.Items.WOODEN_SHOVEL,
            ModTags.Items.WOODEN_HOE,
            ModTags.Blocks.HOLLOW_LOGS,
            ModTags.Blocks.STRIPPED_HOLLOW_LOGS
    );

    // Reset button
    public static final List<TagKey<?>> RESET_BUTTON_TAGS = ORDERED_TAGS;

    public static void accept(List<RecipeHolder<CarpenterTableRecipe>> recipes) {
        ALL_ITEMS.clear();
        recipes.forEach(r -> ALL_ITEMS.add(r.value().getResultItem(RegistryAccess.EMPTY).getItem()));
        refreshIfNeededNoPlayer();
    }

    public static void refreshIfNeeded(RegistryAccess reg) {
        refreshIfNeededWithTags(reg, ORDERED_TAGS);
    }

    public static void refreshIfNeededWithTags(RegistryAccess reg, List<TagKey<?>> tags) {
        if (ALL_ITEMS.isEmpty()) return;

        ITEM_ORDER.clear();
        Set<Item> unsortedCopy = new HashSet<>(ALL_ITEMS);

        for (TagKey<?> tag : tags) {
            if (tag.registry().equals(BuiltInRegistries.BLOCK.key())) {
                @SuppressWarnings("unchecked")
                TagKey<Block> blockTag = (TagKey<Block>) tag;
                for (Holder<Block> blockHolder : reg.registryOrThrow(BuiltInRegistries.BLOCK.key()).getTagOrEmpty(blockTag)) {
                    Item item = blockHolder.value().asItem();
                    if (item != Items.AIR && unsortedCopy.remove(item)) {
                        ITEM_ORDER.add(item);
                    }
                }
            } else if (tag.registry().equals(BuiltInRegistries.ITEM.key())) {
                @SuppressWarnings("unchecked")
                TagKey<Item> itemTag = (TagKey<Item>) tag;
                for (Holder<Item> itemHolder : reg.registryOrThrow(BuiltInRegistries.ITEM.key()).getTagOrEmpty(itemTag)) {
                    Item item = itemHolder.value();
                    if (unsortedCopy.remove(item)) {
                        ITEM_ORDER.add(item);
                    }
                }
            }
        }

        // Qualquer item não categorizado vai pro final
        ITEM_ORDER.addAll(unsortedCopy);
    }

    private static void refreshIfNeededNoPlayer() {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) refreshIfNeeded(server.registryAccess());
    }

    public static void sort(List<RecipeHolder<CarpenterTableRecipe>> recipes, Level level) {
        refreshIfNeeded(level.registryAccess());
        assignIndices(recipes);

        recipes.sort(Comparator
                .comparingInt((RecipeHolder<CarpenterTableRecipe> r) ->
                        ITEM_ORDER.indexOf(r.value().getResultItem(RegistryAccess.EMPTY).getItem()))
                .thenComparingInt(r -> recipeIndices.getOrDefault(r, Integer.MAX_VALUE))
                .thenComparing(r -> r.id().toString())
        );
    }

    public static void assignIndices(List<RecipeHolder<CarpenterTableRecipe>> recipes) {
        recipeIndices.clear();
        for (int i = 0; i < recipes.size(); i++) {
            recipeIndices.put(recipes.get(i), i);
        }
    }

    public static void sendOrderToClient(@Nullable ServerPlayer player, List<RecipeHolder<CarpenterTableRecipe>> safeRecipes) {
        if (player != null) {
            refreshIfNeeded(player.level().registryAccess());
        } else {
            refreshIfNeededNoPlayer();
        }

        List<Item> safeItemOrder;
        if (!safeRecipes.isEmpty()) {
            safeItemOrder = new ArrayList<>();
            for (RecipeHolder<CarpenterTableRecipe> r : safeRecipes) {
                safeItemOrder.add(r.value().getResultItem(RegistryAccess.EMPTY).getItem());
            }
        } else {
            safeItemOrder = new ArrayList<>(ITEM_ORDER);
        }

        IntList list = new IntArrayList();
        safeItemOrder.forEach(i -> list.add(BuiltInRegistries.ITEM.getId(i)));

        SyncRecipeOrderPayload payload = new SyncRecipeOrderPayload(list);

        if (player != null) {
            player.connection.send(payload);
        } else {
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                for (ServerPlayer p : server.getPlayerList().getPlayers()) {
                    p.connection.send(payload);
                }
            }
        }
    }

    public static void acceptOrder(IntList list) {
        ITEM_ORDER.clear();
        for (int id : list) {
            ITEM_ORDER.add(BuiltInRegistries.ITEM.byId(id));
        }
    }

    public static void sendOrderToClient(@Nullable ServerPlayer player) {
        sendOrderToClient(player, Collections.emptyList());
    }
}