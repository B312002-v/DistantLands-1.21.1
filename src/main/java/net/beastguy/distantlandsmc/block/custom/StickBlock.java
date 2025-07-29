package net.beastguy.distantlandsmc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StickBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    // Hitboxes individuais para cada parte do modelo (15 cubos)
    private static final VoxelShape SHAPE_0  = Block.box(6.9, 0, 3.8, 8.1, 0.6, 5);
    private static final VoxelShape SHAPE_1  = Block.box(8.1, 0, 4.4, 8.7, 0.6, 9.2);
    private static final VoxelShape SHAPE_2  = Block.box(11.1, 0, 4.4, 12.3, 0.6, 5.6);
    private static final VoxelShape SHAPE_3  = Block.box(7.5, 0, 5, 8.1, 0.6, 6.2);
    private static final VoxelShape SHAPE_4  = Block.box(8.7, 0, 5, 9.3, 0.6, 8.6);
    private static final VoxelShape SHAPE_5  = Block.box(10.5, 0, 5, 11.1, 0.6, 6.8);
    private static final VoxelShape SHAPE_6  = Block.box(9.9, 0, 5.6, 10.5, 0.6, 7.4);
    private static final VoxelShape SHAPE_7  = Block.box(11.1, 0, 5.6, 11.7, 0.6, 6.2);
    private static final VoxelShape SHAPE_8  = Block.box(9.3, 0, 6.2, 9.9, 0.6, 8);
    private static final VoxelShape SHAPE_9  = Block.box(7.5, 0, 7.4, 8.1, 0.6, 9.8);
    private static final VoxelShape SHAPE_10 = Block.box(6.9, 0, 8.6, 7.5, 0.6, 10.4);
    private static final VoxelShape SHAPE_11 = Block.box(6.3, 0, 9.2, 6.9, 0.6, 11);
    private static final VoxelShape SHAPE_12 = Block.box(5.7, 0, 9.8, 6.3, 0.6, 11.6);
    private static final VoxelShape SHAPE_13 = Block.box(5.1, 0, 10.4, 5.7, 0.6, 12.2);
    private static final VoxelShape SHAPE_14 = Block.box(4.5, 0, 11, 5.1, 0.6, 12.2);

    // Combina todas as shapes em uma única hitbox composta
    private static final VoxelShape SHAPE = Shapes.or(
            SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3, SHAPE_4, SHAPE_5,
            SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11,
            SHAPE_12, SHAPE_13, SHAPE_14
    );

    public StickBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .strength(0.1f)
                .noOcclusion()
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .isRedstoneConductor((state, getter, pos) -> false));

        // Define o estado padrão como "facing = NORTH"
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return rotateShape(Direction.NORTH, facing, SHAPE);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return rotateShape(Direction.NORTH, facing, SHAPE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    private static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
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
}
