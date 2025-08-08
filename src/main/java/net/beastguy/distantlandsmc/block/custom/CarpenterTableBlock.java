    package net.beastguy.distantlandsmc.block.custom;

    import net.beastguy.distantlandsmc.screen.custom.CarpenterTableMenu;
    import net.minecraft.core.BlockPos;
    import net.minecraft.core.Direction;
    import net.minecraft.network.chat.Component;
    import net.minecraft.world.*;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.inventory.ContainerLevelAccess;
    import net.minecraft.world.item.context.BlockPlaceContext;
    import net.minecraft.world.level.BlockGetter;
    import net.minecraft.world.level.Level;
    import net.minecraft.world.level.block.*;
    import net.minecraft.world.level.block.state.BlockState;
    import net.minecraft.world.level.block.state.StateDefinition;
    import net.minecraft.world.level.block.state.properties.BlockStateProperties;
    import net.minecraft.world.level.block.state.properties.BooleanProperty;
    import net.minecraft.world.level.block.state.properties.DirectionProperty;
    import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
    import net.minecraft.world.level.material.MapColor;
    import net.minecraft.world.phys.BlockHitResult;
    import net.minecraft.world.phys.shapes.CollisionContext;
    import net.minecraft.world.phys.shapes.Shapes;
    import net.minecraft.world.phys.shapes.VoxelShape;
    import org.jetbrains.annotations.NotNull;

    import javax.annotation.Nullable;

    public class CarpenterTableBlock extends Block {

        private static final Component CONTAINER_TITLE = Component.translatable("container.carpenter_table");

        public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
        public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

        // Definindo as partes do modelo com caixas (valores aproximados do seu JSON)
        private static final VoxelShape PART_1 = Block.box(0, 8, 0, 16, 14, 16);    // mesa superior
        private static final VoxelShape PART_2 = Block.box(2, 14, 8, 14, 20, 9);    // barra central (ajustado para profundidade 1)
        private static final VoxelShape PART_3 = Block.box(13, 0, 0, 16, 8, 3);     // perna direita frontal
        private static final VoxelShape PART_4 = Block.box(0, 0, 0, 3, 8, 3);       // perna esquerda frontal
        private static final VoxelShape PART_5 = Block.box(0, 0, 13, 3, 8, 16);     // perna esquerda traseira
        private static final VoxelShape PART_6 = Block.box(13, 0, 13, 16, 8, 16);   // perna direita traseira

        private static final VoxelShape SHAPE_BOTTOM = Shapes.or(PART_1, PART_2, PART_3, PART_4, PART_5, PART_6);

        // Hitbox para BOTTOM = false (exemplo, ajuste conforme necessário)
        private static final VoxelShape SHAPE_TOP_PART1 = Block.box(0, 9, 0, 16, 16, 16);
        private static final VoxelShape SHAPE_TOP_PART2 = Block.box(6, 0, 0, 10, 9, 16);
        private static final VoxelShape SHAPE_TOP = Shapes.or(SHAPE_TOP_PART1, SHAPE_TOP_PART2);



        public CarpenterTableBlock() {
            super(Properties.of()
                    .destroyTime(2.5f)
                    .explosionResistance(2.5f)
                    .sound(SoundType.WOOD)
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS));
            this.registerDefaultState(this.stateDefinition.any()
                    .setValue(FACING, Direction.NORTH)
                    .setValue(BOTTOM, true));
        }

        @Override
        public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
            return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
        }

        @Override
        protected @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
            return state;
        }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
            builder.add(FACING, BOTTOM);
        }

        @Override
        public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
            BlockState state = this.defaultBlockState()
                    .setValue(FACING, context.getHorizontalDirection().getOpposite());
            BlockPos pos = context.getClickedPos();
            Direction face = context.getClickedFace();
            double clickY = context.getClickLocation().y - pos.getY();
            return face != Direction.DOWN && (face == Direction.UP || clickY <= 0.5) ? state : state.setValue(BOTTOM, false);
        }

        @Override
        protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                player.openMenu(state.getMenuProvider(level, pos));
                return InteractionResult.CONSUME;
            }
        }

        @Nullable
        public MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
            return new SimpleMenuProvider((i, inventory, player) ->
                    new CarpenterTableMenu(i, inventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
        }

        @Override
        public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
            VoxelShape baseShape = state.getValue(BOTTOM) ? SHAPE_BOTTOM : SHAPE_TOP;
            Direction facing = state.getValue(FACING);
            return rotateShape(facing, baseShape);
        }

        @Override
        public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
            return getShape(state, level, pos, context);
        }

        // Rotaciona a VoxelShape de acordo com a diferença entre as direções (rotação em 90° no eixo Y)
        private static VoxelShape rotateShape(Direction to, VoxelShape shape) {
            if (Direction.NORTH == to) return shape;

            VoxelShape[] buffer = new VoxelShape[] {shape, Shapes.empty()};
            int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;

            for (int i = 0; i < times; i++) {
                buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
                    // Rotação 90° no eixo Y: (x, z) → (1 - z, x)
                    buffer[1] = Shapes.or(buffer[1], Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX));
                });
                buffer[0] = buffer[1];
                buffer[1] = Shapes.empty();
            }

            return buffer[0];
        }

        @Override
        public boolean useShapeForLightOcclusion(@NotNull BlockState state) {
            return true;
        }

    }
