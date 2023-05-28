package systems.boos.pacmankata;

public class GameState {
    private final int columns;

    public GameState() {
        this(0, 0);
    }

    public GameState(int columns, int rows) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        if (columns > 0) {
            return "V";
        }
        return "";
    }
}
