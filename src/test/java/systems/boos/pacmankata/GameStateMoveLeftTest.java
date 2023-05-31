package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateMoveLeftTest {
    @Test
    void moveLeft_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol(">", 1, 2);

        state.moveLeft();

        assertEquals(expectedState, state);
    }

    @Test
    void moveLeft_4x3Board() {
        var state = new GameState(4, 3);

        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol(">", 1, 2);

        state.moveLeft();

        assertEquals(expectedState, state);
    }

    @Test
    void moveLeft_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 2, 3);
        expectedState.placeSymbol(">", 1, 3);

        state.moveLeft();
        state.moveLeft();

        assertEquals(expectedState, state);
    }

    @Test
    void moveLeft_crossUpperBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 2, 3);
        expectedState.placeSymbol(" ", 1, 3);
        expectedState.placeSymbol(">", 5, 3);

        state.moveLeft();
        state.moveLeft();
        state.moveLeft();

        assertEquals(expectedState, state);
    }
}
