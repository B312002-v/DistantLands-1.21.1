package net.beastguy.distantlandsmc.block;

import net.beastguy.distantlandsmc.block.custom.*;
import net.beastguy.distantlandsmc.util.HaruShapes;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import static net.beastguy.distantlandsmc.block.ModBlocks.registerBlock; // importa o helper registerBlock

public class HollowLogBlocks {

    /** ---------------- HARU LOG ---------------- **/
    public static final DeferredBlock<Block> HARU_HOLLOW_LOG =
            registerBlock("haru_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.TERRACOTTA_LIGHT_BLUE,
                            MapColor.TERRACOTTA_BLUE,
                            SoundType.CHERRY_WOOD
                    )
            );

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("haru_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_CORNER_TOP =
            registerBlock("haru_hollow_log_corner_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("haru_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("haru_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_TWO_FACES =
            registerBlock("haru_hollow_log_two_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("haru_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("haru_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("haru_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_THREE_FACES =
            registerBlock("haru_hollow_log_three_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("haru_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("haru_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("haru_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_ALL_FACES =
            registerBlock("haru_hollow_log_all_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("haru_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("haru_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> HARU_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("haru_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED HARU LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG =
            registerBlock("stripped_haru_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.TERRACOTTA_LIGHT_BLUE,      // topo
                            MapColor.TERRACOTTA_LIGHT_BLUE,   // lados
                            SoundType.CHERRY_WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_haru_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_haru_hollow_log_corner_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_haru_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_haru_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_haru_hollow_log_two_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_haru_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_haru_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_haru_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_haru_hollow_log_three_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_haru_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_haru_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_haru_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_haru_hollow_log_all_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_haru_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_haru_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_HARU_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_haru_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_LIGHT_BLUE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- OAK LOG ---------------- **/
    public static final DeferredBlock<Block> OAK_HOLLOW_LOG =
            registerBlock("oak_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.WOOD,      // topo
                            MapColor.PODZOL,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("oak_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_CORNER_TOP =
            registerBlock("oak_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("oak_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("oak_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_TWO_FACES =
            registerBlock("oak_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("oak_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("oak_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("oak_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_THREE_FACES =
            registerBlock("oak_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("oak_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("oak_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("oak_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_ALL_FACES =
            registerBlock("oak_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("oak_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("oak_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> OAK_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("oak_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED OAK LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG =
            registerBlock("stripped_oak_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.WOOD,      // topo
                            MapColor.WOOD,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_oak_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_oak_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_oak_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_oak_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_oak_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_oak_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_oak_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_oak_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_oak_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_oak_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_oak_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_oak_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_oak_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_oak_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_oak_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_OAK_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_oak_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.WOOD,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- SPRUCE LOG ---------------- **/
    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG =
            registerBlock("spruce_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.PODZOL,      // topo
                            MapColor.COLOR_BROWN,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("spruce_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_CORNER_TOP =
            registerBlock("spruce_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("spruce_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("spruce_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_TWO_FACES =
            registerBlock("spruce_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("spruce_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("spruce_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("spruce_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_THREE_FACES =
            registerBlock("spruce_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("spruce_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("spruce_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("spruce_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_ALL_FACES =
            registerBlock("spruce_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("spruce_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("spruce_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("spruce_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED SPRUCE LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG =
            registerBlock("stripped_spruce_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.PODZOL,      // topo
                            MapColor.PODZOL,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_spruce_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_spruce_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_spruce_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_spruce_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_spruce_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_spruce_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_spruce_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_spruce_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_spruce_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_spruce_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_spruce_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_spruce_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_spruce_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_spruce_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_spruce_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_spruce_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.PODZOL,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- DARK OAK LOG ---------------- **/
    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG =
            registerBlock("dark_oak_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_BROWN,      // topo
                            MapColor.COLOR_BROWN,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("dark_oak_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_CORNER_TOP =
            registerBlock("dark_oak_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("dark_oak_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("dark_oak_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_TWO_FACES =
            registerBlock("dark_oak_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("dark_oak_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("dark_oak_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("dark_oak_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_THREE_FACES =
            registerBlock("dark_oak_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("dark_oak_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("dark_oak_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("dark_oak_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_ALL_FACES =
            registerBlock("dark_oak_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("dark_oak_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("dark_oak_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("dark_oak_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));


    /** ---------------- STRIPPED DARK OAK LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG =
            registerBlock("stripped_dark_oak_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_BROWN,      // topo
                            MapColor.COLOR_BROWN,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_dark_oak_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_dark_oak_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_dark_oak_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_dark_oak_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_dark_oak_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_dark_oak_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_dark_oak_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_dark_oak_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_dark_oak_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_dark_oak_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_dark_oak_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_dark_oak_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_dark_oak_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_dark_oak_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_dark_oak_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_dark_oak_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_BROWN,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- BIRCH LOG ---------------- **/
    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG =
            registerBlock("birch_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.SAND,      // topo
                            MapColor.QUARTZ,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("birch_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_CORNER_TOP =
            registerBlock("birch_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("birch_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("birch_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_TWO_FACES =
            registerBlock("birch_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("birch_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("birch_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("birch_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_THREE_FACES =
            registerBlock("birch_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("birch_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("birch_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("birch_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_ALL_FACES =
            registerBlock("birch_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("birch_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("birch_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("birch_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));


    /** ---------------- STRIPPED BIRCH LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG =
            registerBlock("stripped_birch_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.SAND,      // topo
                            MapColor.SAND,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_birch_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_birch_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_birch_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_birch_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_birch_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_birch_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_birch_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_birch_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_birch_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_birch_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_birch_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_birch_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_birch_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_birch_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_birch_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_birch_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.SAND,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- ACACIA LOG ---------------- **/
    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG =
            registerBlock("acacia_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_ORANGE,      // topo
                            MapColor.STONE,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("acacia_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_CORNER_TOP =
            registerBlock("acacia_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("acacia_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("acacia_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_TWO_FACES =
            registerBlock("acacia_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("acacia_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("acacia_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("acacia_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_THREE_FACES =
            registerBlock("acacia_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("acacia_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("acacia_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("acacia_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_ALL_FACES =
            registerBlock("acacia_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("acacia_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("acacia_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("acacia_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED ACACIA LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG =
            registerBlock("stripped_acacia_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_ORANGE,      // topo
                            MapColor.COLOR_ORANGE,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_acacia_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_acacia_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_acacia_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_acacia_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_acacia_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_acacia_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_acacia_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_acacia_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_acacia_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_acacia_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_acacia_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_acacia_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_acacia_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_acacia_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_acacia_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_acacia_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_ORANGE,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- CHERRY LOG ---------------- **/
    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG =
            registerBlock("cherry_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.TERRACOTTA_WHITE,      // topo
                            MapColor.TERRACOTTA_GRAY,   // lados
                            SoundType.CHERRY_WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("cherry_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_CORNER_TOP =
            registerBlock("cherry_hollow_log_corner_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("cherry_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("cherry_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_TWO_FACES =
            registerBlock("cherry_hollow_log_two_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("cherry_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("cherry_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("cherry_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_THREE_FACES =
            registerBlock("cherry_hollow_log_three_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("cherry_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("cherry_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("cherry_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_ALL_FACES =
            registerBlock("cherry_hollow_log_all_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("cherry_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("cherry_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> CHERRY_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("cherry_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED CHERRY LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG =
            registerBlock("stripped_cherry_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.TERRACOTTA_WHITE,      // topo
                            MapColor.TERRACOTTA_PINK,   // lados
                            SoundType.CHERRY_WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_cherry_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_cherry_hollow_log_corner_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_cherry_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_cherry_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_cherry_hollow_log_two_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_cherry_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_cherry_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_cherry_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_cherry_hollow_log_three_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_cherry_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_cherry_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_cherry_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_cherry_hollow_log_all_faces",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_cherry_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_cherry_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_cherry_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHaruHollowBlock(MapColor.TERRACOTTA_WHITE,facing ->
                            ModFlammableFacingHaruHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- JUNGLE LOG ---------------- **/
    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG =
            registerBlock("jungle_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.DIRT,      // topo
                            MapColor.PODZOL,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("jungle_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_CORNER_TOP =
            registerBlock("jungle_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("jungle_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("jungle_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_TWO_FACES =
            registerBlock("jungle_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("jungle_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("jungle_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("jungle_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_THREE_FACES =
            registerBlock("jungle_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("jungle_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("jungle_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("jungle_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_ALL_FACES =
            registerBlock("jungle_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("jungle_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("jungle_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("jungle_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED JUNGLE LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG =
            registerBlock("stripped_jungle_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.DIRT,      // topo
                            MapColor.DIRT,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_jungle_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_jungle_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_jungle_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_jungle_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_jungle_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_jungle_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_jungle_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_jungle_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_jungle_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_jungle_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_jungle_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_jungle_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_jungle_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_jungle_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_jungle_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_jungle_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.DIRT,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- MANGROVE LOG ---------------- **/
    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG =
            registerBlock("mangrove_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_RED,      // topo
                            MapColor.PODZOL,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("mangrove_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_CORNER_TOP =
            registerBlock("mangrove_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("mangrove_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("mangrove_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_TWO_FACES =
            registerBlock("mangrove_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("mangrove_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("mangrove_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("mangrove_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_THREE_FACES =
            registerBlock("mangrove_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("mangrove_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("mangrove_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("mangrove_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_ALL_FACES =
            registerBlock("mangrove_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("mangrove_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("mangrove_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("mangrove_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED MANGROVE LOG ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG =
            registerBlock("stripped_mangrove_hollow_log",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_RED,      // topo
                            MapColor.COLOR_RED,   // lados
                            SoundType.WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_mangrove_hollow_log_corner_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_mangrove_hollow_log_corner_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_mangrove_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_mangrove_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_mangrove_hollow_log_two_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_mangrove_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_mangrove_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_mangrove_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_mangrove_hollow_log_three_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_mangrove_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_mangrove_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_mangrove_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_mangrove_hollow_log_all_faces",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_mangrove_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_mangrove_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_mangrove_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingHollowBlock(MapColor.COLOR_RED,facing ->
                            ModFlammableFacingHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- CRIMSON STEM ---------------- **/
    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG =
            registerBlock("crimson_stem_hollow_log",
                    () -> new ModFlammableRotatedPillarStemHollowBlock(
                            MapColor.CRIMSON_STEM,      // topo
                            MapColor.CRIMSON_STEM,   // lados
                            SoundType.STEM       // som
                    )
            );

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("crimson_stem_hollow_log_corner_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_CORNER_TOP =
            registerBlock("crimson_stem_hollow_log_corner_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("crimson_stem_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("crimson_stem_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_TWO_FACES =
            registerBlock("crimson_stem_hollow_log_two_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("crimson_stem_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("crimson_stem_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("crimson_stem_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_THREE_FACES =
            registerBlock("crimson_stem_hollow_log_three_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("crimson_stem_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("crimson_stem_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("crimson_stem_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_ALL_FACES =
            registerBlock("crimson_stem_hollow_log_all_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("crimson_stem_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("crimson_stem_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("crimson_stem_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED CRIMSON STEM ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG =
            registerBlock("stripped_crimson_stem_hollow_log",
                    () -> new ModFlammableRotatedPillarStemHollowBlock(
                            MapColor.CRIMSON_STEM,      // topo
                            MapColor.CRIMSON_STEM,   // lados
                            SoundType.STEM       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_crimson_stem_hollow_log_corner_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_crimson_stem_hollow_log_corner_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_crimson_stem_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_crimson_stem_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_crimson_stem_hollow_log_two_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_crimson_stem_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_crimson_stem_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_crimson_stem_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_crimson_stem_hollow_log_three_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_crimson_stem_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_crimson_stem_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_crimson_stem_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_crimson_stem_hollow_log_all_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_crimson_stem_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_crimson_stem_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_crimson_stem_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.CRIMSON_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- WARPED STEM ---------------- **/
    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG =
            registerBlock("warped_stem_hollow_log",
                    () -> new ModFlammableRotatedPillarStemHollowBlock(
                            MapColor.WARPED_STEM,      // topo
                            MapColor.WARPED_STEM,   // lados
                            SoundType.STEM       // som
                    )
            );

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("warped_stem_hollow_log_corner_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_CORNER_TOP =
            registerBlock("warped_stem_hollow_log_corner_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("warped_stem_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("warped_stem_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_TWO_FACES =
            registerBlock("warped_stem_hollow_log_two_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("warped_stem_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("warped_stem_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("warped_stem_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_THREE_FACES =
            registerBlock("warped_stem_hollow_log_three_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("warped_stem_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("warped_stem_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("warped_stem_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_ALL_FACES =
            registerBlock("warped_stem_hollow_log_all_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("warped_stem_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("warped_stem_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> WARPED_STEM_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("warped_stem_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED WARPED STEM ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG =
            registerBlock("stripped_warped_stem_hollow_log",
                    () -> new ModFlammableRotatedPillarStemHollowBlock(
                            MapColor.WARPED_STEM,      // topo
                            MapColor.WARPED_STEM,   // lados
                            SoundType.STEM       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_warped_stem_hollow_log_corner_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_warped_stem_hollow_log_corner_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_warped_stem_hollow_log_corner_tunnel_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_warped_stem_hollow_log_corner_tunnel_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_warped_stem_hollow_log_two_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_warped_stem_hollow_log_two_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_warped_stem_hollow_log_two_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_warped_stem_hollow_log_two_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_warped_stem_hollow_log_three_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_warped_stem_hollow_log_three_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_warped_stem_hollow_log_three_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_warped_stem_hollow_log_three_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_warped_stem_hollow_log_all_faces",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_warped_stem_hollow_log_all_faces_botton",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_warped_stem_hollow_log_all_faces_top",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_warped_stem_hollow_log_all_faces_empty",
                    () -> new ModFlammableFacingStemHollowBlock(MapColor.WARPED_STEM,facing ->
                            ModFlammableFacingStemHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- BAMBOO BLOCK ---------------- **/
    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG =
            registerBlock("bamboo_hollow_block",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_YELLOW,      // topo
                            MapColor.PLANT,             // lados
                            SoundType.BAMBOO_WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("bamboo_hollow_block_corner_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_CORNER_TOP =
            registerBlock("bamboo_hollow_block_corner_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("bamboo_hollow_block_corner_tunnel_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("bamboo_hollow_block_corner_tunnel_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_TWO_FACES =
            registerBlock("bamboo_hollow_block_two_faces",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("bamboo_hollow_block_two_faces_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("bamboo_hollow_block_two_faces_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("bamboo_hollow_block_two_faces_empty",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_THREE_FACES =
            registerBlock("bamboo_hollow_block_three_faces",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("bamboo_hollow_block_three_faces_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("bamboo_hollow_block_three_faces_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("bamboo_hollow_block_three_faces_empty",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_ALL_FACES =
            registerBlock("bamboo_hollow_block_all_faces",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("bamboo_hollow_block_all_faces_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("bamboo_hollow_block_all_faces_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> BAMBOO_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("bamboo_hollow_block_all_faces_empty",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    /** ---------------- STRIPPED BAMBOO BLOCK ---------------- **/
    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG =
            registerBlock("stripped_bamboo_hollow_block",
                    () -> new ModFlammableRotatedPillarHollowBlock(
                            MapColor.COLOR_YELLOW,      // topo
                            MapColor.COLOR_YELLOW,   // lados
                            SoundType.BAMBOO_WOOD       // som
                    )
            );

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_BOTTON =
            registerBlock("stripped_bamboo_hollow_block_corner_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TOP =
            registerBlock("stripped_bamboo_hollow_block_corner_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_BOTTON =
            registerBlock("stripped_bamboo_hollow_block_corner_tunnel_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_CORNER_TUNNEL_TOP =
            registerBlock("stripped_bamboo_hollow_block_corner_tunnel_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_CORNER_TUNNEL_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES =
            registerBlock("stripped_bamboo_hollow_block_two_faces",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_BOTTON =
            registerBlock("stripped_bamboo_hollow_block_two_faces_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_TOP =
            registerBlock("stripped_bamboo_hollow_block_two_faces_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_TWO_FACES_EMPTY =
            registerBlock("stripped_bamboo_hollow_block_two_faces_empty",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_TWO_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES =
            registerBlock("stripped_bamboo_hollow_block_three_faces",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_BOTTON =
            registerBlock("stripped_bamboo_hollow_block_three_faces_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_TOP =
            registerBlock("stripped_bamboo_hollow_block_three_faces_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_THREE_FACES_EMPTY =
            registerBlock("stripped_bamboo_hollow_block_three_faces_empty",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_THREE_FACES_EMPTY)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES =
            registerBlock("stripped_bamboo_hollow_block_all_faces",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_BOTTON =
            registerBlock("stripped_bamboo_hollow_block_all_faces_botton",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_BOTTON)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_TOP =
            registerBlock("stripped_bamboo_hollow_block_all_faces_top",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_TOP)));

    public static final DeferredBlock<Block> STRIPPED_BAMBOO_HOLLOW_LOG_ALL_FACES_EMPTY =
            registerBlock("stripped_bamboo_hollow_block_all_faces_empty",
                    () -> new ModFlammableFacingBambooHollowBlock(MapColor.COLOR_YELLOW,facing ->
                            ModFlammableFacingBambooHollowBlock.rotateShape(Direction.NORTH, facing, HaruShapes.HARU_HOLLOW_LOG_ALL_FACES_EMPTY)));

    public static void register() {
    }
}
