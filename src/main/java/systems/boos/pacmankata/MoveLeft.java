package systems.boos.pacmankata;

public class MoveLeft {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManLocation().column(), state.getPacManLocation().row());

        state.setPacManLocation(new Location(state.getPacManLocation().column() - 1, state.getPacManLocation().row()));
        if (state.getPacManLocation().column() < 1) {
            state.setPacManLocation(new Location(state.getColumns(), state.getPacManLocation().row()));
        }

        state.setSymbol(Symbols.PACMAN_LEFT, state.getPacManLocation().column(), state.getPacManLocation().row());
    }
}
