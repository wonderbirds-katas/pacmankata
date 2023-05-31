package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateMoveUpTest {
    @Test
    void moveUp_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 2, 1);

        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_4x3Board() {
        var state = new GameState(4, 3);

        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 2, 1);

        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 2);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 3, 1);

        state.moveUp();
        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_crossUpperBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 2);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 1);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 3, 5);

        state.moveUp();
        state.moveUp();
        state.moveUp();

        assertEquals(expectedState, state);
    }
}
