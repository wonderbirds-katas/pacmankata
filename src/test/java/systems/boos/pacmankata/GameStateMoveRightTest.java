package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateMoveRightTest {
    @Test
    void moveRight_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("<", 3, 2);

        state.moveRight();

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_4x3Board() {
        var state = new GameState(4, 3);

        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("<", 3, 2);

        state.moveRight();

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 4, 3);
        expectedState.placeSymbol("<", 5, 3);

        state.moveRight();
        state.moveRight();

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_crossUpperBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 4, 3);
        expectedState.placeSymbol(" ", 5, 3);
        expectedState.placeSymbol("<", 1, 3);

        state.moveRight();
        state.moveRight();
        state.moveRight();

        assertEquals(expectedState, state);
    }
}
