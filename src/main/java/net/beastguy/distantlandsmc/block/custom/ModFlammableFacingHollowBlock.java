    package net.beastguy.distantlandsmc.block.custom;

    import net.beastguy.distantlandsmc.block.HollowLogBlocks;
    import net.minecraft.core.BlockPos;
    import net.minecraft.core.Direction;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.item.AxeItem;
    import net.minecraft.world.item.Items;
    import net.minecraft.world.item.context.BlockPlaceContext;
    import net.minecraft.world.item.context.UseOnContext;
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
    import net.neoforged.neoforge.common.ItemAbility;
    import org.jetbrains.annotations.NotNull;
    import org.jetbrains.annotations.Nullable;

    import java.util.function.Function;

    public class ModFlammableFacingHollowBlock extends Block implements LiquidBlockContainer {
        public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

        private final Function<Direction, VoxelShape> shapeFunction;

        public ModFlammableFacingHollowBlock(MapColor mapColor, Function<Direction, VoxelShape> shapeFunction) {
            super(Properties.of()
                    .mapColor(mapColor)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0f)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
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
                buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
                buffer[0] = buffer[1];
                buffer[1] = Shapes.empty();
            }

            return buffer[0];
        }

        @Override
        public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
            return shapeFunction.apply(state.getValue(FACING));
        }

        @Override
        public @NotNull VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
            return shapeFunction.apply(state.getValue(FACING));
        }

        @Override
        public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState,
                                               @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
            if (state.getValue(WATERLOGGED)) {
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
            return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }

        @Override
        public @NotNull FluidState getFluidState(BlockState state) {
            return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
        }

        @Override
        public boolean canBeReplaced(BlockState state, @NotNull BlockPlaceContext context) {
            return !state.getValue(WATERLOGGED) && context.getItemInHand().getItem() == Items.WATER_BUCKET;
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
            if (!(context.getItemInHand().getItem() instanceof AxeItem)) {
                return super.getToolModifiedState(state, context, itemAbility, simulate);
            }

            if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.OAK_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_BOTTON)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TOP)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_TOP)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_TOP.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            } else if (state.is(HollowLogBlocks.MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY)) {
                return HollowLogBlocks.STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY.get()
                        .defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            }

            return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    }

