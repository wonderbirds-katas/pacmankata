package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateMoveLeftTest {
    @Test
    void moveLeft_3x3Board() {
        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_LEFT, 1, 2);

        var state = new GameState(3, 3);
        state.moveLeft();

        assertEquals(expectedState, state);
    }

    @Test
    void moveLeft_4x3Board() {
        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_LEFT, 1, 2);

        var state = new GameState(4, 3);
        state.moveLeft();

        assertEquals(expectedState, state);
    }

    @Test
    void moveLeft_twiceOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 3);
        expectedState.placeSymbol(Symbols.PACMAN_LEFT, 1, 3);

        var state = new GameState(5, 5);
        state.moveLeft();
        state.moveLeft();

        assertEquals(expectedState, state);
    }

    @Test
    void moveLeft_crossUpperBoundaryOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 1, 3);
        expectedState.placeSymbol(Symbols.PACMAN_LEFT, 5, 3);

        var state = new GameState(5, 5);
        state.moveLeft();
        state.moveLeft();
        state.moveLeft();

        assertEquals(expectedState, state);
    }
}
