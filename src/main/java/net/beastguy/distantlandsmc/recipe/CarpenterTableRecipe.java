package net.beastguy.distantlandsmc.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CarpenterTableRecipe extends SingleItemRecipe {
    private final int inputCount;


    public CarpenterTableRecipe(String group, Ingredient ingredient, ItemStack itemStack, int inputCount) {
        super(ModRecipeTypes.CARPENTER_TABLE_TYPE.get(), ModRecipeTypes.CARPENTER_TABLE_SERIALIZER.get(),
                group, ingredient, itemStack);
        if (inputCount > 64) {
            throw new IllegalArgumentException("Input count for wood cutting recipe is too high: " + inputCount + ". Ingredient: " + ingredient + ", Result: " + itemStack);
        }
        this.inputCount = inputCount;

    }

    public int getInputCount() {
        return inputCount;
    }

    @Override
    public boolean matches(SingleRecipeInput container, @NotNull Level level) {
        ItemStack item = container.getItem(0);
        return this.ingredient.test(item) && item.getCount() >= inputCount;
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.CARPENTER_TABLE.get());
    }

    @Override
    public boolean isSpecial() {
        return true; //for recipe book
    }

    public static class Serializer implements RecipeSerializer<CarpenterTableRecipe> {

        private final MapCodec<CarpenterTableRecipe> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, CarpenterTableRecipe> streamCodec;

        public Serializer() {

            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(arg -> arg.group),
                                    Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(arg -> arg.ingredient),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(arg -> arg.result),
                                    ExtraCodecs.POSITIVE_INT.optionalFieldOf("ingredient_count", 1).forGetter(arg -> arg.inputCount)
                            )
                            .apply(instance, CarpenterTableRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, arg -> arg.group,
                    Ingredient.CONTENTS_STREAM_CODEC, arg -> arg.ingredient,
                    ItemStack.STREAM_CODEC, arg -> arg.result,
                    ByteBufCodecs.VAR_INT, arg -> arg.inputCount,
                    CarpenterTableRecipe::new
            );
        }

        @Override
        public @NotNull MapCodec<CarpenterTableRecipe> codec() {
            return codec;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, CarpenterTableRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
