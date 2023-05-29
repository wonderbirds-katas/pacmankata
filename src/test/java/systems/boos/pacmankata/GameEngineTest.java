package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineTest {
    @Test
    void turn_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("V", 1, 2);

        GameEngine.turn(state);

        assertEquals(expectedState, state);
    }
}
