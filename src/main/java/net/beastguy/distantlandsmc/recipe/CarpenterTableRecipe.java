package net.beastguy.distantlandsmc.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record CarpenterTableRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CarpenterTableRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // GrowthChamberRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(CarpenterTableRecipeInput carpenterTableRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(carpenterTableRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(CarpenterTableRecipeInput carpenterTableRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.CARPENTER_TABLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.CARPENTER_TABLE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<CarpenterTableRecipe> {
        public static final MapCodec<CarpenterTableRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(CarpenterTableRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CarpenterTableRecipe::output)
        ).apply(inst, CarpenterTableRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CarpenterTableRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, CarpenterTableRecipe::inputItem,
                        ItemStack.STREAM_CODEC, CarpenterTableRecipe::output,
                        CarpenterTableRecipe::new);

        @Override
        public MapCodec<CarpenterTableRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CarpenterTableRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}