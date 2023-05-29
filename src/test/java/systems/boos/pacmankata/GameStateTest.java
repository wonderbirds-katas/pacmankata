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
}
