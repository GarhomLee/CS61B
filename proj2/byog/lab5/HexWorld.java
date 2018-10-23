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

    /* draw a line of tile with designated start position, tile numbers and style. */
    public static void drawLine(TETile[][] world, int posX, int posY, int tileNum, TETile tileStyle) {
        for (int i = 0; i < tileNum; i += 1) {
            world[posX][posY] = tileStyle;
            posX += 1;
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

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

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

        //
        Position pos = new Position(10, 10); // position (0, 0) of the world is in the left bottom corner
        addHexagon(world, pos, 3, Tileset.TREE);

        // draws the world to the screen
        ter.renderFrame(world);
    }
}
