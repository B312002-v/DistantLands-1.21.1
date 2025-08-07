package net.beastguy.distantlandsmc.recipe;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeTypes {
    // Registro de serializers e tipos com base no MODID
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, DistantLandsMod.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, DistantLandsMod.MODID);

    // Tipo da receita Carpenter Table
    public static final DeferredHolder<RecipeType<?>, RecipeType<CarpenterTableRecipe>> CARPENTER_TABLE_TYPE =
            TYPES.register("carpenter_table", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "carpenter_table";
                }
            });

    // Serializador da receita Carpenter Table
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CarpenterTableRecipe>> CARPENTER_TABLE_SERIALIZER =
            SERIALIZERS.register("carpenter_table", CarpenterTableRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
