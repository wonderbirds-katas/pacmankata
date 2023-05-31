package systems.boos.pacmankata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateTest {
    @DisplayName("toString_Nx1Board(...)")
    @ParameterizedTest(name = "{0} columns are visualized as \"{1}\"")
    @CsvSource({
            "1, 'V\n'",
            "2, 'V.\n'",
            "3, '.V.\n'",
            "4, '.V..\n'",
    })
    void toString_Nx1Board(int columns, String expected) {
        assertEquals(expected, new GameState(columns, 1).toString());
    }

    @DisplayName("toString_NxNBoard(...)")
    @ParameterizedTest(name = "{0} columns and {1} rows are visualized as \"{2}\"")
    @CsvSource({
            "1, 1, 'V\n'",
            "2, 2, 'V.\n..\n'",
            "5, 5, '.....\n.....\n..V..\n.....\n.....\n'",
    })
    void toString_NxNBoard(int columns, int rows, String expected) {
        assertEquals(expected, new GameState(columns, rows).toString());
    }

    @DisplayName("toString_MxNBoard(...)")
    @ParameterizedTest(name = "{0} columns and {1} rows are visualized as \"{2}\"")
    @CsvSource({
            "2, 6, '..\n..\nV.\n..\n..\n..\n'",
            "5, 3, '.....\n..V..\n.....\n'",
    })
    void toString_MxNBoard(int columns, int rows, String expected) {
        assertEquals(expected, new GameState(columns, rows).toString());
    }

    @Test
    void moveUp_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("V", 2, 1);

        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_4x3Board() {
        var state = new GameState(4, 3);

        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("V", 2, 1);

        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 2);
        expectedState.placeSymbol("V", 3, 1);

        state.moveUp();
        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveUp_crossUpperBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 2);
        expectedState.placeSymbol(" ", 3, 1);
        expectedState.placeSymbol("V", 3, 5);

        state.moveUp();
        state.moveUp();
        state.moveUp();

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol("A", 3, 4);

        state.moveDown();

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 4);
        expectedState.placeSymbol("A", 3, 5);

        state.moveDown();
        state.moveDown();

        assertEquals(expectedState, state);
    }

    @Test
    void moveDown_crossBottomBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 4);
        expectedState.placeSymbol(" ", 3, 5);
        expectedState.placeSymbol("A", 3, 1);

        state.moveDown();
        state.moveDown();
        state.moveDown();

        assertEquals(expectedState, state);
    }
}
