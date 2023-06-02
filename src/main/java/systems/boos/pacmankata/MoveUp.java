package systems.boos.pacmankata;

public class MoveUp {
    private boolean hasConsumedDot = true;
    private GameState state;
    private Location targetLocation;

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
        var nextRow = state.getPacManRow() - 1;
        if (nextRow < 1) {
            nextRow = state.getRows();
        }
        targetLocation = new Location(state.getPacManLocation().column(), nextRow);
    }

    private boolean isDotAtTargetLocation() {
        var nextRow = targetLocation.row();
        return Symbols.DOT == state.getSymbol(state.getPacManLocation().column(), nextRow);
    }

    private void movePacManToTargetLocation() {
        var nextRow = targetLocation.row();
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManLocation().column(), state.getPacManRow());
        state.setPacManRow(nextRow);
        state.setSymbol(Symbols.PACMAN_UP, state.getPacManLocation().column(), state.getPacManRow());
    }
}
