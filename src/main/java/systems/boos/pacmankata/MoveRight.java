package systems.boos.pacmankata;

public class MoveRight {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManLocation(new Location(state.getPacManColumn() + 1, state.getPacManRow()));
        if (state.getPacManColumn() > state.getColumns()) {
            state.setPacManLocation(new Location(1, state.getPacManRow()));
        }

        state.setSymbol(Symbols.PACMAN_RIGHT, state.getPacManColumn(), state.getPacManRow());
    }
}
