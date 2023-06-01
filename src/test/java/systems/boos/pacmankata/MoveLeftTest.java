package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveLeftTest {
    @Test
    void execute_3x3Board_movesPacMan() {
        var expectedState = new GameState(3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_LEFT, 1, 2);

        var state = new GameState(3, 3);
        new MoveLeft().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void execute_4x3Board_movesPacMan() {
        var expectedState = new GameState(4, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_LEFT, 1, 2);

        var state = new GameState(4, 3);
        new MoveLeft().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void execute_twiceOn5x5Board_movesPacMan() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 3);
        expectedState.setSymbol(Symbols.PACMAN_LEFT, 1, 3);

        var state = new GameState(5, 5);
        new MoveLeft().execute(state);
        new MoveLeft().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void execute_crossUpperBoundaryOn5x5Board_movesPacMan() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 1, 3);
        expectedState.setSymbol(Symbols.PACMAN_LEFT, 5, 3);

        var state = new GameState(5, 5);
        new MoveLeft().execute(state);
        new MoveLeft().execute(state);
        new MoveLeft().execute(state);

        assertEquals(expectedState, state);
    }
}
