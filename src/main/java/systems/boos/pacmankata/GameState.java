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

        var leftRepresentation = visualizeDots(calculateCenterColumn() - 1);
        var rightRepresentation = visualizeDots(columns - calculateCenterColumn());

        return leftRepresentation + visualizePacMan() + rightRepresentation;
    }

    private static String visualizePacMan() {
        return "V";
    }

    private String visualizeDots(int numberOfDots) {
        if (numberOfDots < 1) {
            return "";
        }
        return IntStream.range(0, numberOfDots).mapToObj(x -> ".").collect(Collectors.joining(""));
    }

    private int calculateCenterColumn() {
        return 1 + Math.floorDiv(columns - 1, 2);
    }
}
