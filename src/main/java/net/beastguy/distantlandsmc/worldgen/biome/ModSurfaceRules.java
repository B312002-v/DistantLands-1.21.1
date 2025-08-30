package net.beastguy.distantlandsmc.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.SurfaceRuleManager;

public class ModSurfaceRules {

    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);

    private static final SurfaceRules.RuleSource OBSIDIAN = makeStateRule(Blocks.OBSIDIAN);
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);

    // Regras simples para o bioma Purple Plains
    public static SurfaceRules.RuleSource makePurplePlainsRules() {
        // Sempre topo de grama, subsolo dirt, abaixo stone
        SurfaceRules.RuleSource surface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIRT),
                STONE // fallback
        );

        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(ModBiomes.PURPLE_PLAINS),
                surface
        );
    }

    // Regras do End
    public static SurfaceRules.RuleSource makeEndRotRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.END_ROT), OBSIDIAN),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, END_STONE)
        );
    }

    // Função auxiliar
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    // Registro no Terrablender
    public static void registerSurfaceRules() {
        SurfaceRuleManager.addSurfaceRules(
                SurfaceRuleManager.RuleCategory.OVERWORLD,
                "distantlandsmc",
                makePurplePlainsRules()
        );

        SurfaceRuleManager.addSurfaceRules(
                SurfaceRuleManager.RuleCategory.END,
                "distantlandsmc",
                makeEndRotRules()
        );
    }
}
