package net.beastguy.distantlandsmc.block.custom;

import net.beastguy.distantlandsmc.block.HollowLogBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ModFlammableRotatedPillarStemHollowBlock extends RotatedPillarBlock implements LiquidBlockContainer {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape SHAPE_Y = Shapes.or(
            Block.box(0, 0, 0, 2, 16, 16),    // lado esquerdo
            Block.box(14, 0, 0, 16, 16, 16),  // lado direito
            Block.box(2, 0, 0, 14, 16, 2),    // frente
            Block.box(2, 0, 14, 14, 16, 16)   // trás
    );

    private static final VoxelShape SHAPE_Z = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),    // base (parte de baixo)
            Block.box(0, 14, 0, 16, 16, 16),  // topo (parte de cima)
            Block.box(0, 2, 0, 2, 14, 16),    // lado esquerdo
            Block.box(14, 2, 0, 16, 14, 16)   // lado direito
    );

    private static final VoxelShape SHAPE_X = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),    // base (parte de baixo)
            Block.box(0, 14, 0, 16, 16, 16),  // topo (parte de cima)
            Block.box(0, 2, 0, 16, 14, 2),    // lado da frente
            Block.box(0, 2, 14, 16, 14, 16)   // lado de trás
    );

    public ModFlammableRotatedPillarStemHollowBlock(MapColor topMapColor, MapColor sideMapColor, SoundType soundType) {
        super(Properties.of()
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y
                        ? topMapColor
                        : sideMapColor)
                .strength(2.0f)
                .instrument(NoteBlockInstrument.BASS)
                .sound(soundType)
                .noOcclusion()
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .isRedstoneConductor((state, getter, pos) -> false));

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction.Axis axis = context.getClickedFace().getAxis();
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        boolean waterlogged = fluidState.getType() == Fluids.WATER;
        return this.defaultBlockState()
                .setValue(AXIS, axis)
                .setValue(WATERLOGGED, waterlogged);

    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public boolean canPlaceLiquid(Player player, @NotNull BlockGetter level, @NotNull BlockPos pos, BlockState state, @NotNull Fluid fluid) {
        return !state.getValue(WATERLOGGED) && fluid == Fluids.WATER;
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos pos, BlockState state, @NotNull FluidState fluidState) {
        if (!state.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            level.setBlock(pos, state.setValue(WATERLOGGED, true), 3);
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            return true;
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, WATERLOGGED);
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, UseOnContext context,
                                                     @NotNull ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {

            if (state.is(HollowLogBlocks.CRIMSON_STEM_HOLLOW_LOG)) {
                return HollowLogBlocks.STRIPPED_CRIMSON_STEM_HOLLOW_LOG.get().defaultBlockState()
                        .setValue(AXIS, state.getValue(AXIS))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }
            else if (state.is(HollowLogBlocks.WARPED_STEM_HOLLOW_LOG)) {
                return HollowLogBlocks.STRIPPED_WARPED_STEM_HOLLOW_LOG.get().defaultBlockState()
                        .setValue(AXIS, state.getValue(AXIS))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, net.minecraft.world.phys.shapes.@NotNull CollisionContext context) {
        return switch (state.getValue(AXIS)) {
            case X -> SHAPE_X;
            case Z -> SHAPE_Z;
            default -> SHAPE_Y;
        };
    }
}
