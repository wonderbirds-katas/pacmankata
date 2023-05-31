package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateMoveRightTest {
    @Test
    void moveRight_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_RIGHT, 3, 2);

        state.moveRight();

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_4x3Board() {
        var state = new GameState(4, 3);

        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_RIGHT, 3, 2);

        state.moveRight();

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 4, 3);
        expectedState.placeSymbol(Symbols.PACMAN_RIGHT, 5, 3);

        state.moveRight();
        state.moveRight();

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_crossUpperBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 4, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 5, 3);
        expectedState.placeSymbol(Symbols.PACMAN_RIGHT, 1, 3);

        state.moveRight();
        state.moveRight();
        state.moveRight();

        assertEquals(expectedState, state);
    }
}
