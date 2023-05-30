package systems.boos.pacmankata;

public class GameEngine {
    private GameEngine() {
    }

    public static void turn(GameState state) {
        state.placeSymbol("V", 2, 1);
        state.placeSymbol(" ", 2, 2);
    }
}
