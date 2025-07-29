package net.beastguy.distantlandsmc.worldgen.tree;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;


import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower HARU = new TreeGrower(
            DistantLandsMod.MODID + ":haru",
            Optional.of(ModConfiguredFeatures.HARU_KEY),      // árvore grande (2x2)
            Optional.of(ModConfiguredFeatures.HARU_SMALL_KEY),// árvore pequena (1 sapling)
            Optional.empty());

}
