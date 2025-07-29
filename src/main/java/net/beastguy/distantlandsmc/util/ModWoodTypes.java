package net.beastguy.distantlandsmc.util;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes
{
    public static final WoodType HARU = WoodType.register(
            new WoodType(DistantLandsMod.MODID + ":haru", BlockSetType.OAK)
    );
}
