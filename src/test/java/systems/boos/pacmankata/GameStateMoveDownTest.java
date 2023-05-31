package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateMoveDownTest {
    @Test
    void moveDown_5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol("A", 3, 4);

        state.moveDown();

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 4);
        expectedState.placeSymbol("A", 3, 5);

        state.moveDown();
        state.moveDown();

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_crossBottomBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 4);
        expectedState.placeSymbol(" ", 3, 5);
        expectedState.placeSymbol("A", 3, 1);

        state.moveDown();
        state.moveDown();
        state.moveDown();

        assertEquals(expectedState, state);
    }
}
