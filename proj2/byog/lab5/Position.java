package byog.lab5;

/* a class storing the position information. */
public class Position {

    private int posX;
    private int posY;
    public Position (int x, int y) {
        posX = x;
        posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
