package net.beastguy.distantlandsmc.util;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HaruShapes {
    private static final Map<String, Function<Direction, VoxelShape>> SHAPES = new HashMap<>();

    public static final VoxelShape HARU_HOLLOW_LOG_CORNER_BOTTON = haruHollowLogCornerBottonShape();
    public static final VoxelShape HARU_HOLLOW_LOG_CORNER_TOP = haruHollowLogCornerTopShape();
    public static final VoxelShape HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON = haruHollowLogCornerTunnelBottonShape();
    public static final VoxelShape HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP = haruHollowLogCornerTunnelTopShape();
    public static final VoxelShape HARU_HOLLOW_LOG_TWO_FACES = haruHollowLogTwoFacesShape();
    public static final VoxelShape HARU_HOLLOW_LOG_TWO_FACES_BOTTON = haruHollowLogTwoFacesBottonShape();
    public static final VoxelShape HARU_HOLLOW_LOG_TWO_FACES_TOP = haruHollowLogTwoFacesTopShape();
    public static final VoxelShape HARU_HOLLOW_LOG_TWO_FACES_EMPTY = haruHollowLogTwoFacesEmptyShape();
    public static final VoxelShape HARU_HOLLOW_LOG_THREE_FACES = haruHollowLogThreeFacesShape();
    public static final VoxelShape HARU_HOLLOW_LOG_THREE_FACES_BOTTON = haruHollowLogThreeFacesBottonShape();
    public static final VoxelShape HARU_HOLLOW_LOG_THREE_FACES_TOP = haruHollowLogThreeFacesTopShape();
    public static final VoxelShape HARU_HOLLOW_LOG_THREE_FACES_EMPTY = haruHollowLogThreeFacesEmptyShape();
    public static final VoxelShape HARU_HOLLOW_LOG_ALL_FACES = haruHollowLogAllFacesShape();
    public static final VoxelShape HARU_HOLLOW_LOG_ALL_FACES_BOTTON = haruHollowLogAllFacesBottonShape();
    public static final VoxelShape HARU_HOLLOW_LOG_ALL_FACES_TOP = haruHollowLogAllFacesTopShape();
    public static final VoxelShape HARU_HOLLOW_LOG_ALL_FACES_EMPTY = haruHollowLogAllFacesEmptyShape();

    private static VoxelShape haruHollowLogCornerBottonShape() {
        VoxelShape SHAPE_0 = Block.box(0,0,2,2,16,16);
        VoxelShape SHAPE_1 = Block.box(0,0,0,2,16,2);
        VoxelShape SHAPE_2 = Block.box(14,14,0,16,16,16);
        VoxelShape SHAPE_3 = Block.box(14,2,14,16,14,16);
        VoxelShape SHAPE_4 = Block.box(14,0,0,16,2,16);
        VoxelShape SHAPE_5 = Block.box(14,2,0,16,14,2);
        VoxelShape SHAPE_6 = Block.box(14,2,2,16,14,14);
        VoxelShape SHAPE_7 = Block.box(2,14,0,14,16,14);
        VoxelShape SHAPE_8 = Block.box(2,0,0,14,2,2);
        VoxelShape SHAPE_9 = Block.box(2,0,14,14,16,16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3, SHAPE_4,
                SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9);
    }

    private static VoxelShape haruHollowLogCornerTopShape() {
        VoxelShape SHAPE_0 = Block.box(0, 0, 2, 2, 16, 16);
        VoxelShape SHAPE_1 = Block.box(0, 0, 0, 2, 16, 2);
        VoxelShape SHAPE_2 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_3 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_4 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_6 = Block.box(14, 2, 2, 16, 14, 14);
        VoxelShape SHAPE_7 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_8 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_9 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9);
    }

    private static VoxelShape haruHollowLogCornerTunnelBottonShape() {
        VoxelShape SHAPE_0 = Block.box(0, 0, 2, 2, 16, 14);
        VoxelShape SHAPE_1 = Block.box(0, 0, 0, 2, 16, 2);
        VoxelShape SHAPE_2 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_3 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_4 = Block.box(0, 0, 14, 2, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_6 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_7 = Block.box(14, 2, 2, 16, 14, 14);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 14);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 2, 16);
        VoxelShape SHAPE_11 = Block.box(2, 14, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11);
    }

    private static VoxelShape haruHollowLogCornerTunnelTopShape() {
        VoxelShape SHAPE_0 = Block.box(0, 0, 14, 2, 16, 16);
        VoxelShape SHAPE_1 = Block.box(0, 0, 2, 2, 16, 14);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 16, 2);
        VoxelShape SHAPE_3 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_5 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_6 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_7 = Block.box(14, 2, 2, 16, 14, 14);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 2, 16);
        VoxelShape SHAPE_11 = Block.box(2, 14, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11);
    }

    private static VoxelShape haruHollowLogTwoFacesShape() {
        VoxelShape SHAPE_0 = Block.box(0,0,2,2,16,16);
        VoxelShape SHAPE_1 = Block.box(0,0,0,2,16,2);
        VoxelShape SHAPE_2 = Block.box(14,14,0,16,16,16);
        VoxelShape SHAPE_3 = Block.box(14,2,14,16,14,16);
        VoxelShape SHAPE_4 = Block.box(14,0,0,16,2,16);
        VoxelShape SHAPE_5 = Block.box(14,2,0,16,14,2);
        VoxelShape SHAPE_6 = Block.box(2,14,0,14,16,14);
        VoxelShape SHAPE_7 = Block.box(2,0,0,14,2,14);
        VoxelShape SHAPE_8 = Block.box(2,0,14,14,16,16);


        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8);
    }

    private static VoxelShape haruHollowLogTwoFacesBottonShape() {
        VoxelShape SHAPE_0 = Block.box(0, 0, 2, 2, 16, 16);
        VoxelShape SHAPE_1 = Block.box(0, 0, 0, 2, 16, 2);
        VoxelShape SHAPE_2 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_3 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_4 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_6 = Block.box(2, 14, 0, 14, 16, 14);
        VoxelShape SHAPE_7 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_8 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8);
    }

    private static VoxelShape haruHollowLogTwoFacesTopShape() {
        VoxelShape SHAPE_0 = Block.box(0, 0, 2, 2, 16, 16);
        VoxelShape SHAPE_1 = Block.box(0, 0, 0, 2, 16, 2);
        VoxelShape SHAPE_2 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_3 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_4 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_6 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_7 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_8 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8);
    }

    private static VoxelShape haruHollowLogTwoFacesEmptyShape() {
        VoxelShape SHAPE_0 = Block.box(0, 0, 2, 2, 16, 16);
        VoxelShape SHAPE_1 = Block.box(0, 0, 0, 2, 16, 2);
        VoxelShape SHAPE_2 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_3 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_4 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_6 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_7 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_8 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8);
    }

    private static VoxelShape haruHollowLogThreeFacesShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 14);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10);
    }

    private static VoxelShape haruHollowLogThreeFacesBottonShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 14);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10);
    }

    private static VoxelShape haruHollowLogThreeFacesTopShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10);
    }

    private static VoxelShape haruHollowLogThreeFacesEmptyShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10);
    }

    private static VoxelShape haruHollowLogAllFacesShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 14);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 2, 16);
        VoxelShape SHAPE_11 = Block.box(2, 14, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11);
    }

    private static VoxelShape haruHollowLogAllFacesBottonShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 14);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 2, 16);
        VoxelShape SHAPE_11 = Block.box(2, 14, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11);
    }

    private static VoxelShape haruHollowLogAllFacesTopShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 16);
        VoxelShape SHAPE_7 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_8 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_9 = Block.box(2, 0, 0, 14, 2, 14);
        VoxelShape SHAPE_10 = Block.box(2, 0, 14, 14, 2, 16);
        VoxelShape SHAPE_11 = Block.box(2, 14, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11);
    }

    private static VoxelShape haruHollowLogAllFacesEmptyShape() {
        VoxelShape SHAPE_0 = Block.box(0, 2, 0, 2, 14, 2);
        VoxelShape SHAPE_1 = Block.box(0, 2, 14, 2, 14, 16);
        VoxelShape SHAPE_2 = Block.box(0, 0, 0, 2, 2, 16);
        VoxelShape SHAPE_3 = Block.box(0, 14, 0, 2, 16, 16);
        VoxelShape SHAPE_4 = Block.box(14, 14, 0, 16, 16, 16);
        VoxelShape SHAPE_5 = Block.box(14, 2, 14, 16, 14, 16);
        VoxelShape SHAPE_6 = Block.box(14, 0, 0, 16, 2, 2);
        VoxelShape SHAPE_7 = Block.box(14, 0, 14, 16, 2, 16);
        VoxelShape SHAPE_8 = Block.box(14, 2, 0, 16, 14, 2);
        VoxelShape SHAPE_9 = Block.box(2, 14, 0, 14, 16, 2);
        VoxelShape SHAPE_10 = Block.box(2, 0, 0, 14, 2, 2);
        VoxelShape SHAPE_11 = Block.box(2, 0, 14, 14, 2, 16);
        VoxelShape SHAPE_12 = Block.box(2, 14, 14, 14, 16, 16);

        return Shapes.or(SHAPE_0, SHAPE_1, SHAPE_2, SHAPE_3,
                SHAPE_4, SHAPE_5, SHAPE_6, SHAPE_7, SHAPE_8, SHAPE_9, SHAPE_10, SHAPE_11, SHAPE_12);
    }

    public static Function<Direction, VoxelShape> getShape(String name) {
        return SHAPES.get(name);
    }

}
