package systems.boos.pacmankata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineTest {
    @Test
    void turn_3x3Board() {
        var state = new GameState(3, 3);

        var expectedState = new GameState(3, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("V", 2, 1);

        new GameEngine(state).turn();

        assertEquals(expectedState, state);
    }

    @Test
    void turn_4x3Board() {
        var state = new GameState(4, 3);

        var expectedState = new GameState(4, 3);
        expectedState.placeSymbol(" ", 2, 2);
        expectedState.placeSymbol("V", 2, 1);

        new GameEngine(state).turn();

        assertEquals(expectedState, state);
    }

    @Test
    void turn_twiceOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 2);
        expectedState.placeSymbol("V", 3, 1);

        GameEngine engine = new GameEngine(state);
        engine.turn();
        engine.turn();

        assertEquals(expectedState, state);
    }

    @Test
    void turn_violateUpperBoundaryOn5x5Board() {
        var state = new GameState(5, 5);

        var expectedState = new GameState(5, 5);
        expectedState.placeSymbol(" ", 3, 3);
        expectedState.placeSymbol(" ", 3, 2);
        expectedState.placeSymbol(" ", 3, 1);
        expectedState.placeSymbol("V", 3, 5);

        GameEngine engine = new GameEngine(state);
        engine.turn();
        engine.turn();
        engine.turn();

        assertEquals(expectedState, state);
    }
}
