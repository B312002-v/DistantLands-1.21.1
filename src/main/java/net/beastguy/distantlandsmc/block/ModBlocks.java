package net.beastguy.distantlandsmc.block;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.custom.*;
import net.beastguy.distantlandsmc.item.ModItems;
import net.beastguy.distantlandsmc.util.ModWoodTypes;
import net.beastguy.distantlandsmc.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(DistantLandsMod.MODID);

    public static final DeferredBlock<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of().noOcclusion()));

    public static final DeferredBlock<Block> CARPENTER_TABLE = registerBlock("carpenter_table",
            CarpenterTableBlock::new);

    /** ORES -------------------------------------------------- */

    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> RUBY_DEEPSLATE_ORE = registerBlock("ruby_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> RUBY_BLACKSTONE_ORE = registerBlock("ruby_blackstone_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE)));

    public static final DeferredBlock<Block> NETHER_CURSED_RUBY_ORE = registerBlock("nether_cursed_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(30.0F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));

    public static final DeferredBlock<Block> END_CURSED_RUBY_ORE = registerBlock("end_cursed_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(6, 9),
                    BlockBehaviour.Properties.of().strength(30.0F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));

    /** BUILDING BLOCKS -------------------------------------------------- */

    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> CURSED_RUBY_BLOCK = registerBlock("cursed_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(50.0F).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));


    public static final DeferredBlock<Block> HARU_LOG = registerBlock("haru_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)
                    .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y
                            ? MapColor.TERRACOTTA_LIGHT_BLUE // cor do topo
                            : MapColor.TERRACOTTA_BLUE) // cor lateral
            ));

    public static final DeferredBlock<Block> HARU_WOOD = registerBlock("haru_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD)
                    .mapColor(state -> // cor do topo
                            MapColor.TERRACOTTA_BLUE) // cor lateral
            ));

    public static final DeferredBlock<Block> STRIPPED_HARU_LOG = registerBlock("stripped_haru_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)
                    .mapColor(state -> // cor do topo
                            MapColor.TERRACOTTA_LIGHT_BLUE) // cor lateral
            ));

    public static final DeferredBlock<Block> STRIPPED_HARU_WOOD = registerBlock("stripped_haru_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)
                    .mapColor(state -> // cor do topo
                            MapColor.TERRACOTTA_LIGHT_BLUE) // cor lateral
            ));

    public static final DeferredBlock<Block> HARU_PLANKS = registerBlock("haru_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
            ) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<StairBlock> HARU_STAIRS = registerBlock("haru_stairs",
            () -> new StairBlock(ModBlocks.HARU_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> HARU_SLAB = registerBlock("haru_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<ButtonBlock> HARU_BUTTON = registerBlock("haru_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.of().strength(0.5f).noCollission()));
    public static final DeferredBlock<FenceBlock> HARU_FENCE = registerBlock("haru_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> HARU_FENCE_GATE = registerBlock("haru_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<DoorBlock> HARU_DOOR = registerBlock("haru_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(3.0f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> HARU_TRAPDOOR = registerBlock("haru_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(3.0f).noOcclusion()));
    public static final DeferredBlock<PressurePlateBlock> HARU_PRESSURE_PLATE = registerBlock("haru_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(0.5f)));


    public static final DeferredBlock<Block> HARU_SIGN = registerBlockNoItem("haru_sign",
            () -> new ModStandingSignBlock(ModWoodTypes.HARU, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));

    public static final DeferredBlock<Block> HARU_WALL_SIGN = registerBlockNoItem("haru_wall_sign",
            () -> new ModWallSignBlock(ModWoodTypes.HARU, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));

    public static final DeferredBlock<Block> HARU_HANGING_SIGN = registerBlockNoItem("haru_hanging_sign",
            () -> new ModHangingSignBlock(ModWoodTypes.HARU, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));

    public static final DeferredBlock<Block> HARU_WALL_HANGING_SIGN = registerBlockNoItem("haru_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(ModWoodTypes.HARU, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

    /** NATURE -------------------------------------------------- */

    public static final DeferredBlock<Block> PETUNIA = registerBlock("petunia",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 8, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)));

    public static final DeferredBlock<Block> POTTED_PETUNIA = BLOCKS.register("potted_petunia",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), PETUNIA, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final DeferredBlock<Block> HARU_LEAVES = registerBlock("haru_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> HARU_SAPLING = registerBlock("haru_sapling",
            () -> new SaplingBlock(ModTreeGrowers.HARU, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SAPLING)));

    public static final DeferredBlock<Block> POTTED_HARU_SAPLING = registerBlockNoItem("potted_haru_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), HARU_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final DeferredBlock<StickBlock> STICK_GROUND = registerBlock("stick_ground",
            StickBlock::new);

    public static final DeferredBlock<PabbleBlock> PABBLE = registerBlock("pabble",
            PabbleBlock::new);

    public static final DeferredBlock<PabbleBlock_1> PABBLE_1 = registerBlock("pabble_1",
            PabbleBlock_1::new);

    public static final DeferredBlock<PabbleBlock_2> PABBLE_2 = registerBlock("pabble_2",
            PabbleBlock_2::new);

    public static final DeferredBlock<RockBlock> ROCK = registerBlock("rock",
            RockBlock::new);


    static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlockNoItem(String name, Supplier<T> block)
    {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        HollowLogBlocks.register();
    }
}

