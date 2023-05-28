package systems.boos.pacmankata;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameState {
    private final int columns;
    private final int rows;

    public GameState() {
        this(0, 0);
    }

    public GameState(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public String toString() {
        if (columns == 0) {
            return "";
        }

        var boardRepresentation = new ArrayList<String>();
        var centerRow = calculateCenterRow();

        for (var row = 1; row <= rows; row++) {
            var leftRepresentation = visualizeDots(calculateCenterColumn() - 1);
            var rightRepresentation = visualizeDots(columns - calculateCenterColumn());

            String rowRepresentation;
            if (row == centerRow) {
                String pacMan = "V";
                rowRepresentation = leftRepresentation + pacMan + rightRepresentation;
            } else {
                String dot = ".";
                rowRepresentation = leftRepresentation + dot + rightRepresentation;
            }
            boardRepresentation.add(rowRepresentation);
        }

        return String.join("\n", boardRepresentation);
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

    private int calculateCenterRow() {
        return 1 + Math.floorDiv(rows - 1, 2);
    }

}
