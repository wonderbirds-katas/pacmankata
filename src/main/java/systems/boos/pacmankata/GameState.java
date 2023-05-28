package systems.boos.pacmankata;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        if (columns == 0) {
            return "";
        }

        return "V" + IntStream.range(1, columns).mapToObj(x -> ".").collect(Collectors.joining(""));
    }
}
