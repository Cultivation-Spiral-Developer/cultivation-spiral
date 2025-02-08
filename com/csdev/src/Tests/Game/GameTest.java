package Tests.Game;

import Game.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    static Game game;

    @BeforeAll
    static void setup() {
        game = new Game();
    }

    @Test
    void getPlotScene_null_returnsNull() {
        assertNull(Game.getPlotScene(null));
    }
}