package net.beastguy.distantlandsmc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PabbleBlock_1 extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    // Hitboxes individuais para cada parte do modelo (10 cubos)
    private static final VoxelShape SHAPE_0 = Block.box(2, 0, 11, 4, 1, 13);
    private static final VoxelShape SHAPE_1 = Block.box(4, 0, 6, 7, 1, 9);
    private static final VoxelShape SHAPE_2 = Block.box(1, 0, 1, 3, 1, 4);
    private static final VoxelShape SHAPE_3 = Block.box(5, 0, 2, 7, 1, 4);
    private static final VoxelShape SHAPE_4 = Block.box(12, 0, 1, 14, 1, 3);
    private static final VoxelShape SHAPE_5 = Block.box(7, 0, 10, 10, 1, 12);
    private static final VoxelShape SHAPE_6 = Block.box(11, 0, 12, 14, 1, 14);
    private static final VoxelShape SHAPE_7 = Block.box(12, 0, 11, 14, 1, 12);
    private static final VoxelShape SHAPE_8 = Block.box(9, 0, 4, 13, 1, 7);
    private static final VoxelShape SHAPE_9 = Block.box(9, 0, 7, 12, 1, 8);

    // Combina todas as shapes em uma única hitbox composta
    private static final VoxelShape SHAPE = Shapes.or(
            SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3, SHAPE_4,
            SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9
    );

    public PabbleBlock_1() {
        super(Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.5f, 6.0f)
                .noOcclusion()
                .requiresCorrectToolForDrops()
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .isRedstoneConductor((state, getter, pos) -> false));

        // Define o estado padrão como "facing = NORTH"
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return rotateShape(facing);
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return rotateShape(facing);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    private static VoxelShape rotateShape(Direction to) {
        VoxelShape[] buffer = new VoxelShape[] {PabbleBlock_1.SHAPE, Shapes.empty() };

        int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;

        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }
}
