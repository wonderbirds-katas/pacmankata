package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateTest {
    @Test
    void ToString_EmptyBoard() {
        assertEquals("", new GameState().toString());
    }
}
