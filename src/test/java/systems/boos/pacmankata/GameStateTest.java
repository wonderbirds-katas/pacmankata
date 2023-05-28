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
            "1, V",
            "2, V.",
            "3, .V.",
            "4, .V..",
    })
    void toString_Nx1Board(int columns, String expected) {
        assertEquals(expected, new GameState(columns, 1).toString());
    }

    @Test
    void toString_1x2Board() {
        assertEquals("V\n.", new GameState(1, 2).toString());
    }
}
