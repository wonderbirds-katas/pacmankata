package systems.boos.pacmankata;

public class MoveUp {
    private boolean hasConsumedDot = true;
    private int nextRow;
    private GameState state;

    public boolean hasConsumedDot() {
        return hasConsumedDot;
    }

    public void execute(GameState state) {
        this.state = state;
        calculateTargetLocation();
        hasConsumedDot = isDotAtTargetLocation();
        movePacManToTargetLocation();
    }

    private void calculateTargetLocation() {
        nextRow = state.getPacManRow() - 1;
        if (nextRow < 1) {
            nextRow = state.getRows();
        }
    }

    private boolean isDotAtTargetLocation() {
        return Symbols.DOT == state.getSymbol(state.getPacManColumn(), nextRow);
    }

    private void movePacManToTargetLocation() {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());
        state.setPacManRow(nextRow);
        state.setSymbol(Symbols.PACMAN_UP, state.getPacManColumn(), state.getPacManRow());
    }
}
