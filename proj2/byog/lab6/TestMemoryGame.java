package byog.lab6;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMemoryGame {
    @Test
    public void testGenerateRandomString() {
        int seed = 693333;
        MemoryGameSolution game = new MemoryGameSolution(40, 40, seed);
        System.out.println(game.generateRandomString(5));
    }
}
