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
        board = new Symbols[getColumns()][getRows()];
        for (int column = 0; column < getColumns(); column++) {
            for (int row = 0; row < getRows(); row++) {
                board[column][row] = Symbols.DOT;
            }
        }
    }

    private void createPacMan() {
        int centerColumnIndex = 1 + Math.floorDiv(getColumns() - 1, 2);
        int centerRowIndex = 1 + Math.floorDiv(getRows() - 1, 2);

        setPacManColumn(centerColumnIndex);
        setPacManRow(centerRowIndex);

        board[getPacManColumn() - 1][getPacManRow() - 1] = Symbols.PACMAN_UP;
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

        if (getRows() != other.getRows() || getColumns() != other.getColumns()) return false;

        for (int column = 0; column < getColumns(); column++) {
            if (!Arrays.equals(board[column], other.board[column]))
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        var resultBuilder = new StringBuilder();

        for (int row = 0; row < getRows(); row++) {
            StringBuilder rowString = new StringBuilder();
            for (int column = 0; column < getColumns(); column++) {
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

    public void moveDown() {
        placeSymbol(Symbols.EMPTY_SPACE, getPacManColumn(), getPacManRow());

        setPacManRow(getPacManRow() + 1);
        if (getPacManRow() > getRows()) {
            setPacManRow(1);
        }

        placeSymbol(Symbols.PACMAN_DOWN, getPacManColumn(), getPacManRow());
    }

    public void moveRight() {
        placeSymbol(Symbols.EMPTY_SPACE, getPacManColumn(), getPacManRow());

        setPacManColumn(getPacManColumn() + 1);
        if (getPacManColumn() > getColumns()) {
            setPacManColumn(1);
        }

        placeSymbol(Symbols.PACMAN_RIGHT, getPacManColumn(), getPacManRow());
    }

    public void moveLeft() {
        placeSymbol(Symbols.EMPTY_SPACE, getPacManColumn(), getPacManRow());

        setPacManColumn(getPacManColumn() - 1);
        if (getPacManColumn() < 1) {
            setPacManColumn(getColumns());
        }

        placeSymbol(Symbols.PACMAN_LEFT, getPacManColumn(), getPacManRow());
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getPacManColumn() {
        return pacManColumn;
    }

    public void setPacManColumn(int pacManColumn) {
        this.pacManColumn = pacManColumn;
    }

    public int getPacManRow() {
        return pacManRow;
    }

    public void setPacManRow(int pacManRow) {
        this.pacManRow = pacManRow;
    }
}
