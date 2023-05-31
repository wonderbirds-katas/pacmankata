package systems.boos.pacmankata;

import java.util.Objects;

public class GameState {
    private final int columns;
    private final int rows;
    private final String[][] board;
    private int pacManColumn;
    private int pacManRow;

    public GameState(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        board = createEmptyBoard();
        putPacManToCenter();
    }

    private String[][] createEmptyBoard() {
        var result = new String[columns][rows];
        String dot = ".";
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                result[column][row] = dot;
            }
        }
        return result;
    }

    private void putPacManToCenter() {
        int centerColumnIndex = 1 + Math.floorDiv(columns - 1, 2);
        int centerRowIndex = 1 + Math.floorDiv(rows - 1, 2);

        pacManColumn = centerColumnIndex;
        pacManRow = centerRowIndex;

        String pacMan = "V";
        board[pacManColumn - 1][pacManRow - 1] = pacMan;
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

        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                if (!Objects.equals(board[column][row], other.board[column][row])) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        var resultBuilder = new StringBuilder();

        for (int row = 0; row < rows; row++) {
            StringBuilder rowString = new StringBuilder();
            for (int column = 0; column < columns; column++) {
                rowString.append(board[column][row]);
            }
            rowString.append("\n");
            resultBuilder.append(rowString);
        }

        return resultBuilder.toString();
    }

    public void placeSymbol(String symbol, int column, int row) {
        board[column - 1][row - 1] = symbol;
    }

    public void moveUp() {
        placeSymbol(" ", pacManColumn, pacManRow);

        pacManRow--;
        if (pacManRow < 1) {
            pacManRow = rows;
        }

        placeSymbol("V", pacManColumn, pacManRow);
    }

    public void moveDown() {
        placeSymbol(" ", pacManColumn, pacManRow);

        pacManRow++;
        if (pacManRow > rows) {
            pacManRow = 1;
        }

        placeSymbol("A", pacManColumn, pacManRow);
    }

    public void moveRight() {
        placeSymbol(" ", pacManColumn, pacManRow);

        pacManColumn++;
        if (pacManColumn > columns) {
            pacManColumn = 1;
        }

        placeSymbol("<", pacManColumn, pacManRow);
    }
}
