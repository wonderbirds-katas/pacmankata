package systems.boos.pacmankata;

public class MoveUp {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManRow(state.getPacManRow() - 1);
        if (state.getPacManRow() < 1) {
            state.setPacManRow(state.getRows());
        }

        state.setSymbol(Symbols.PACMAN_UP, state.getPacManColumn(), state.getPacManRow());
    }
}
