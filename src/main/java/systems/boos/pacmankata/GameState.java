package systems.boos.pacmankata;

import java.util.Objects;

public class GameState {
    private final int columns;
    private final int rows;
    private final String[][] board;

    public GameState(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        board = createEmptyBoard();
        putPacManToCenter();
    }

    private String[][] createEmptyBoard() {
        var result = new String[rows][columns];
        String dot = ".";
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                result[row][column] = dot;
            }
        }
        return result;
    }

    private void putPacManToCenter() {
        int centerColumnIndex = Math.floorDiv(columns - 1, 2);
        int centerRowIndex = Math.floorDiv(rows - 1, 2);

        String pacMan = "V";
        board[centerRowIndex][centerColumnIndex] = pacMan;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;

        var other = (GameState) object;

        if (rows != other.rows || columns != other.columns) return false;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (!Objects.equals(board[row][column], other.board[row][column])) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        var resultBuilder = new StringBuilder();

        for (String[] row : board) {
            String rowString = String.join("", row) + "\n";
            resultBuilder.append(rowString);
        }

        return resultBuilder.toString();
    }

    public void placeSymbol(String symbol, int column, int row) {
        board[column - 1][row - 1] = symbol;
    }
}
