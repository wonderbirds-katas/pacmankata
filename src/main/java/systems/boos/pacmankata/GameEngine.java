package systems.boos.pacmankata;

public class GameEngine {
    private GameEngine() {
    }

    public static void turn(GameState state) {
        state.placeSymbol(" ", 2, 2);
        state.placeSymbol("V", 1, 2);
    }
}
