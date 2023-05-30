package systems.boos.pacmankata;

public class GameEngine {
    private GameEngine() {
    }

    public static void turn(GameState state) {
        state.moveUp();
    }
}
