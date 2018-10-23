package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    /* draw a horizontal line of tile with designated start position, tile numbers and style. */
    public static void drawLine(TETile[][] world, int posX, int posY, int tileNum, TETile tileStyle) {
        for (int i = 0; i < tileNum; i += 1) {
            world[posX][posY] = tileStyle;
            posX += 1;
        }
    }

    /** Picks a RANDOM tile */
    private static final long SEED = 28;
    private static final Random RANDOM = new Random(SEED);
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(6);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.TREE;
            case 4: return Tileset.WATER;
            case 5: return Tileset.SAND;
            default: return Tileset.NOTHING;
        }
    }

    /* draw a diagonal line of hexagons. */
    public static void drawDiagonalHexagons(TETile[][] world, int posX, int posY, int sideLength, int hexagonNum) {
        int x = posX; // x value of the position, decreasing as hexagons are drawing from bottom right to top left
        int y = posY; // y value of the position, increasing as hexagons are drawing from bottom right to top left
        for (int i = 0; i < hexagonNum; i += 1) {
            Position startPos = new Position(x, y); // start position for the hexagon to be drawn
            addHexagon(world, startPos, sideLength, randomTile());
            x -= 2 * sideLength - 1; //change the position
            y += sideLength; // change the position
        }
    }

    /* a method to draw a single hexagon. */
    public static void addHexagon(TETile[][] world, Position pos, int sideLength, TETile tileStyle) {
        int lowerStartX = pos.getPosX(); // the upper start position x of drawLine(...)
        int lowerStartY = pos.getPosY(); // the upper start position y of drawLine(...)
        int upperStartX = pos.getPosX() - sideLength + 1; // the lower start position x of drawLine(...)
        int upperStartY = pos.getPosY() + sideLength; // the lower start position y of drawLine(...)
        int tileNum;
        // draw the lower triangle
        for (int i = 0; i < sideLength; i += 1) {
            tileNum = sideLength + 2 * i;
            drawLine(world, lowerStartX, lowerStartY, tileNum , tileStyle);
            lowerStartX -= 1;
            lowerStartY += 1;
        }
        // draw the upper triangle
        for (int i = sideLength - 1; i >= 0; i -= 1) {
            tileNum = sideLength + 2 * i;
            drawLine(world, upperStartX, upperStartY, tileNum, tileStyle);
            upperStartX += 1;
            upperStartY += 1;
        }
    }

    /* draw a world with 19 hexagons of designated side length. */
    public static void addNineteenHexagon(TETile[][] world, Position pos, int sideLength) {
        int hexagonNum = 2; // the dependent number - 1 of the first bottom left diagonal line of hexagons, depending on the total hexagons that are desired in the world
                            // 2 here is the dependent number - 1
        int posX = pos.getPosX() - (2 * sideLength - 1);
        int posY = pos.getPosY() - sideLength;
        // a world with 19 hexagons consists of 3 bottom left + 2 top right diagonal lines of hexagons
        // draw 3 bottom left diagonal lines of hexagons, where 3 is the dependent number
        for (int i = 0; i < 3; i += 1) { // 3 here is the dependent number
            posX += 2 * sideLength - 1;
            posY += sideLength;
            hexagonNum += 1;
            drawDiagonalHexagons(world, posX, posY, sideLength, hexagonNum);

        }
        // draw 2 top left diagonal lines of hexagons, where 2 is the dependent number - 1
        for (int i = 3; i < 5; i += 1) { // 3 here is the dependent number, 5 here is the dependent number + 2
            posY += 2 * sideLength;
            hexagonNum -= 1;
            drawDiagonalHexagons(world, posX, posY, sideLength, hexagonNum);
        }
    }

    private static final int WIDTH = 100;
    private static final int HEIGHT = 60;

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position pos = new Position(50, 1); // position (0, 0) of the world is in the left bottom corner
        int sideLength = 5;
        //addNineteenHexagon(world, pos, sideLength); // make a single hexagon
        addNineteenHexagon(world, pos, sideLength); // make a world of 19 hexagons

        // draws the world to the screen
        ter.renderFrame(world);
    }
}
