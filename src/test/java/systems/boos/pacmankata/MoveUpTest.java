package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveUpTest {
    @Test
    void execute_3x3Board_movesPacMan() {
        var expectedState = new GameState(3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_UP, 2, 1);

        var state = new GameState(3, 3);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void execute_3x3Board_consumesDot() {
        var state = new GameState(3, 3);

        MoveUp move = new MoveUp();
        move.execute(state);

        assertTrue(move.hasConsumedDot());
    }

    @Test
    void execute_enterEmptySpace_doesNotConsumeDot() {
        var state = new GameState(3, 3);
        state.setSymbol(Symbols.EMPTY_SPACE, 2, 1);

        MoveUp move = new MoveUp();
        move.execute(state);

        assertFalse(move.hasConsumedDot());
    }

    @Test
    void execute_4x3Board_movesPacMan() {
        var expectedState = new GameState(4, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 2, 2);
        expectedState.setSymbol(Symbols.PACMAN_UP, 2, 1);

        var state = new GameState(4, 3);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void execute_twiceOn5x5Board_movesPacMan() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 2);
        expectedState.setSymbol(Symbols.PACMAN_UP, 3, 1);

        var state = new GameState(5, 5);
        new MoveUp().execute(state);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }

    @Test
    void execute_crossUpperBoundaryOn5x5Board_movesPacMan() {
        var expectedState = new GameState(5, 5);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 3);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 2);
        expectedState.setSymbol(Symbols.EMPTY_SPACE, 3, 1);
        expectedState.setSymbol(Symbols.PACMAN_UP, 3, 5);

        var state = new GameState(5, 5);
        new MoveUp().execute(state);
        new MoveUp().execute(state);
        new MoveUp().execute(state);

        assertEquals(expectedState, state);
    }
}
