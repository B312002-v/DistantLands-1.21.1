package net.beastguy.distantlandsmc.item;

import net.beastguy.distantlandsmc.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier EMERALD = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL,
            1796, 8.5F, 3.5F, 10,
            () -> Ingredient.of(Items.EMERALD));

    public static final Tier RUBY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL,
            1800, 8.5f, 3.5f, 15, () -> Ingredient.of(ModItems.RUBY));


    public static final Tier CURSED_RUBY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CURSED_RUBY_TOOL,
            2501, 10.0f, 5.5F, 15, () -> Ingredient.of(ModItems.CURSED_RUBY));

}
