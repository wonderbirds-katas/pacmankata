package systems.boos.pacmankata;

public class GameEngine {
    private final GameState state;

    public GameEngine(GameState state) {
        this.state = state;
    }

    public void turn() {
        new MoveUp().execute(state);
    }
}
