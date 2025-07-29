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

public class RockBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    // Hitboxes individuais para cada parte do modelo (6 cubos)
    private static final VoxelShape SHAPE_0 = Block.box(3.75, 0, 3.75, 12.25, 11, 12.25);
    private static final VoxelShape SHAPE_1 = Block.box(0.75, 0, 7.75, 8.25, 7, 13.25);
    private static final VoxelShape SHAPE_2 = Block.box(1.75, 0, 1.75, 7.25, 5, 6.25);
    private static final VoxelShape SHAPE_3 = Block.box(8.75, 0, 2.75, 14.25, 6, 7.25);
    private static final VoxelShape SHAPE_4 = Block.box(8.75, 0, 8.75, 14.25, 8, 14.25);
    private static final VoxelShape SHAPE_5 = Block.box(5.18725, 10.838, 5.088, 9.18725, 14.838, 10.088);

    // Combina todas as shapes em uma única hitbox composta
    private static final VoxelShape SHAPE = Shapes.or(
            SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3, SHAPE_4, SHAPE_5
    );

    public RockBlock() {
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
