    package net.beastguy.distantlandsmc.block.custom;

    import net.minecraft.core.BlockPos;
    import net.minecraft.core.Direction;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.item.Items;
    import net.minecraft.world.item.context.BlockPlaceContext;
    import net.minecraft.world.level.BlockGetter;
    import net.minecraft.world.level.LevelAccessor;
    import net.minecraft.world.level.block.Block;
    import net.minecraft.world.level.block.LiquidBlockContainer;
    import net.minecraft.world.level.block.SoundType;
    import net.minecraft.world.level.block.state.BlockState;
    import net.minecraft.world.level.block.state.StateDefinition;
    import net.minecraft.world.level.block.state.properties.BlockStateProperties;
    import net.minecraft.world.level.block.state.properties.BooleanProperty;
    import net.minecraft.world.level.block.state.properties.DirectionProperty;
    import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
    import net.minecraft.world.level.material.Fluid;
    import net.minecraft.world.level.material.FluidState;
    import net.minecraft.world.level.material.Fluids;
    import net.minecraft.world.level.material.MapColor;
    import net.minecraft.world.phys.shapes.CollisionContext;
    import net.minecraft.world.phys.shapes.Shapes;
    import net.minecraft.world.phys.shapes.VoxelShape;

    import java.util.function.Function;

    public class ModFlammableFacingHollowBlock extends Block implements LiquidBlockContainer {
        public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

        private final Function<Direction, VoxelShape> shapeFunction;

        public ModFlammableFacingHollowBlock(Function<Direction, VoxelShape> shapeFunction) {
            super(Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0f)
                    .sound(SoundType.CHERRY_WOOD)
                    .ignitedByLava()
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .isSuffocating((s, g, p) -> false)
                    .isViewBlocking((s, g, p) -> false)
                    .isRedstoneConductor((s, g, p) -> false));

            this.shapeFunction = shapeFunction;
            this.registerDefaultState(this.stateDefinition.any()
                    .setValue(FACING, Direction.NORTH)
                    .setValue(WATERLOGGED, false));
        }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
            builder.add(FACING, WATERLOGGED);
        }

        @Override
        public BlockState getStateForPlacement(BlockPlaceContext context) {
            boolean water = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
            return this.defaultBlockState()
                    .setValue(FACING, context.getHorizontalDirection().getOpposite())
                    .setValue(WATERLOGGED, water);
        }

        public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
            VoxelShape[] buffer = new VoxelShape[] { shape, Shapes.empty() };

            int times = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;

            for (int i = 0; i < times; i++) {
                buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
                    buffer[1] = Shapes.or(buffer[1], Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX));
                });
                buffer[0] = buffer[1];
                buffer[1] = Shapes.empty();
            }

            return buffer[0];
        }

        @Override
        public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return shapeFunction.apply(state.getValue(FACING));
        }

        @Override
        public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return shapeFunction.apply(state.getValue(FACING));
        }

        @Override
        public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                      LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
            if (state.getValue(WATERLOGGED)) {
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
            return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }

        @Override
        public FluidState getFluidState(BlockState state) {
            return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
        }

        @Override
        public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
            return !state.getValue(WATERLOGGED) && context.getItemInHand().getItem() == Items.WATER_BUCKET;
        }

        @Override
        public boolean canPlaceLiquid(Player player, BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
            return !state.getValue(WATERLOGGED) && fluid == Fluids.WATER;
        }

        @Override
        public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
            if (!state.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
                level.setBlock(pos, state.setValue(WATERLOGGED, true), 3);
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
                return true;
            }
            return false;
        }

        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }
    }
