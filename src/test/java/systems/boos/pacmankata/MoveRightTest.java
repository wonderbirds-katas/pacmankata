package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveRightTest {
    @Test
    void moveRight_3x3Board() {
        var expectedState = new GameState(3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_RIGHT, 3, 2);

        var state = new GameState(3, 3);
        new MoveRight().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_4x3Board() {
        var expectedState = new GameState(4, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_RIGHT, 3, 2);

        var state = new GameState(4, 3);
        new MoveRight().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_twiceOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 4, 3);
        expectedState.setSymbol(Symbols.PACMAN_RIGHT, 5, 3);

        var state = new GameState(5, 5);
        new MoveRight().execute(state);
        new MoveRight().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void moveRight_crossUpperBoundaryOn5x5Board() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 4, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 5, 3);
        expectedState.setSymbol(Symbols.PACMAN_RIGHT, 1, 3);

        var state = new GameState(5, 5);
        new MoveRight().execute(state);
        new MoveRight().execute(state);
        new MoveRight().execute(state);

        assertEquals(expectedState, state);
    }
}
