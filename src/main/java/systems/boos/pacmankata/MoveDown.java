package systems.boos.pacmankata;

public class MoveDown {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManLocation().column(), state.getPacManRow());

        state.setPacManRow(state.getPacManRow() + 1);
        if (state.getPacManRow() > state.getRows()) {
            state.setPacManRow(1);
        }

        state.setSymbol(Symbols.PACMAN_DOWN, state.getPacManLocation().column(), state.getPacManRow());
    }
}
