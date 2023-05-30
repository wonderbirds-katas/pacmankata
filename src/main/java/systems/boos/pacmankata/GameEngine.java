package systems.boos.pacmankata;

public class GameEngine {
    private GameEngine() {
    }

    public static void turn(GameState state) {
        new MoveUp().execute(state);
    }
}
