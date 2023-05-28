package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateTest {
    @Test
    void toString_EmptyBoard() {
        assertEquals("", new GameState().toString());
    }

    @Test
    void toString_1x1Board() {
        assertEquals("V", new GameState(1, 1).toString());
    }

    @Test
    void toString_2x1Board() {
        assertEquals("V.", new GameState(2, 1).toString());
    }

    @Test
    void toString_3x1Board() {
        assertEquals(".V.", new GameState(3, 1).toString());
    }
}
