package systems.boos.pacmankata;

public class MoveLeft {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManColumn(state.getPacManColumn() - 1);
        if (state.getPacManColumn() < 1) {
            state.setPacManColumn(state.getColumns());
        }

        state.setSymbol(Symbols.PACMAN_LEFT, state.getPacManColumn(), state.getPacManRow());
    }
}
