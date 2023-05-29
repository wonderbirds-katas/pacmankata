package systems.boos.pacmankata;

import java.util.ArrayList;

public class GameState {
    private final int columns;
    private final int rows;
    private final String[][] board;

    public GameState(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        board = createEmptyBoard();
        putPacManToCenter(board);
    }

    private String[][] createEmptyBoard() {
        var matrix = new String[rows][columns];
        String dot = ".";
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = dot;
            }
        }
        return matrix;
    }

    private void putPacManToCenter(String[][] matrix) {
        int centerColumnIndex = Math.floorDiv(columns - 1, 2);
        int centerRowIndex = Math.floorDiv(rows - 1, 2);

        String pacMan = "V";
        matrix[centerRowIndex][centerColumnIndex] = pacMan;
    }

    @Override
    public String toString() {
        var boardRows = new ArrayList<String>();
        for (String[] row : board) {
            boardRows.add(String.join("", row));
        }
        return String.join("\n", boardRows);
    }
}
