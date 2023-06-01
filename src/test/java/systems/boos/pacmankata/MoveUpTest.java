package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveUpTest {
    @Test
    void moveUp_3x3Board() {
        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 2, 1);

        var state = new GameState(3, 3);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_4x3Board() {
        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 2, 1);

        var state = new GameState(4, 3);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_twiceOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 2);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 3, 1);

        var state = new GameState(5, 5);
        new MoveUp().execute(state);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_crossUpperBoundaryOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 2);
        expectedState.placeSymbol(Symbols.EMPTY_SPACE, 3, 1);
        expectedState.placeSymbol(Symbols.PACMAN_UP, 3, 5);

        var state = new GameState(5, 5);
        new MoveUp().execute(state);
        new MoveUp().execute(state);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }
}
