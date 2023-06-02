package systems.boos.pacmankata;

import java.util.Arrays;

public class GameState {
    private Location pacManLocation;
    private final int columns;
    private final int rows;
    private Symbols[][] board;

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
        int centerColumn = 1 + Math.floorDiv(getColumns() - 1, 2);
        int centerRow = 1 + Math.floorDiv(getRows() - 1, 2);

        pacManLocation = new Location(centerColumn, centerRow);
        setSymbol(Symbols.PACMAN_UP, centerColumn, centerRow);
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
        return new Printer().print(this);
    }

    public void setSymbol(Symbols symbol, int column, int row) {
        board[column - 1][row - 1] = symbol;
    }

    public Symbols getSymbol(int column, int row) {
        return board[column - 1][row - 1];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getPacManColumn() {
        return pacManLocation.column();
    }

    public void setPacManColumn(int pacManColumn) {
        setPacManLocation(new Location(pacManColumn, getPacManRow()));
    }

    public int getPacManRow() {
        return pacManLocation.row();
    }

    public void setPacManRow(int pacManRow) {
        setPacManLocation(new Location(getPacManColumn(), pacManRow));
    }

    public Location getPacManLocation() {
        return pacManLocation;
    }

    public void setPacManLocation(Location pacManLocation) {
        this.pacManLocation = pacManLocation;
    }
}
