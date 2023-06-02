package systems.boos.pacmankata;

public class MoveLeft {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManLocation(new Location(state.getPacManColumn() - 1, state.getPacManRow()));
        if (state.getPacManColumn() < 1) {
            state.setPacManLocation(new Location(state.getColumns(), state.getPacManRow()));
        }

        state.setSymbol(Symbols.PACMAN_LEFT, state.getPacManColumn(), state.getPacManRow());
    }
}
