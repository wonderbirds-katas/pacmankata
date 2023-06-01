package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveDownTest {
    @Test
    void moveDown_3x3Board() {
        var expectedState = new GameState(3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_DOWN, 2, 3);

        var state = new GameState(3, 3);
        new MoveDown().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_4x3Board() {
        var expectedState = new GameState(4, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_DOWN, 2, 3);

        var state = new GameState(4, 3);
        new MoveDown().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_twiceOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 4);
        expectedState.setSymbol(Symbols.PACMAN_DOWN, 3, 5);

        var state = new GameState(5, 5);
        new MoveDown().execute(state);
        new MoveDown().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_crossBottomBoundaryOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 4);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 5);
        expectedState.setSymbol(Symbols.PACMAN_DOWN, 3, 1);

        var state = new GameState(5, 5);
        new MoveDown().execute(state);
        new MoveDown().execute(state);
        new MoveDown().execute(state);

        assertEquals(expectedState, state);
    }
}
