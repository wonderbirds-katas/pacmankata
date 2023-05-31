package systems.boos.pacmankata;

import java.util.Arrays;

public class GameState {
    private final int columns;
    private final int rows;
    private Symbols[][] board;
    private int pacManColumn;
    private int pacManRow;

    public GameState(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        createEmptyBoard();
        createPacMan();
    }

    private void createEmptyBoard() {
        board = new Symbols[columns][rows];
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                board[column][row] = Symbols.DOT;
            }
        }
    }

    private void createPacMan() {
        int centerColumnIndex = 1 + Math.floorDiv(columns - 1, 2);
        int centerRowIndex = 1 + Math.floorDiv(rows - 1, 2);

        pacManColumn = centerColumnIndex;
        pacManRow = centerRowIndex;

        board[pacManColumn - 1][pacManRow - 1] = Symbols.PACMAN_UP;
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
            if (!Arrays.equals(board[column], other.board[column]))
                return false;
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

    public void placeSymbol(Symbols symbol, int column, int row) {
        board[column - 1][row - 1] = symbol;
    }

    public void moveUp() {
        placeSymbol(Symbols.EMPTY_SPACE, pacManColumn, pacManRow);

        pacManRow--;
        if (pacManRow < 1) {
            pacManRow = rows;
        }

        placeSymbol(Symbols.PACMAN_UP, pacManColumn, pacManRow);
    }

    public void moveDown() {
        placeSymbol(Symbols.EMPTY_SPACE, pacManColumn, pacManRow);

        pacManRow++;
        if (pacManRow > rows) {
            pacManRow = 1;
        }

        placeSymbol(Symbols.PACMAN_DOWN, pacManColumn, pacManRow);
    }

    public void moveRight() {
        placeSymbol(Symbols.EMPTY_SPACE, pacManColumn, pacManRow);

        pacManColumn++;
        if (pacManColumn > columns) {
            pacManColumn = 1;
        }

        placeSymbol(Symbols.PACMAN_RIGHT, pacManColumn, pacManRow);
    }

    public void moveLeft() {
        placeSymbol(Symbols.EMPTY_SPACE, pacManColumn, pacManRow);

        pacManColumn--;
        if (pacManColumn < 1) {
            pacManColumn = columns;
        }

        placeSymbol(Symbols.PACMAN_LEFT, pacManColumn, pacManRow);
    }
}
