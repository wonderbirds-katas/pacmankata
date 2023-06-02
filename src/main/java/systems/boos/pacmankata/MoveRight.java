package systems.boos.pacmankata;

public class MoveRight {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManLocation().column(), state.getPacManLocation().row());

        state.setPacManLocation(new Location(state.getPacManLocation().column() + 1, state.getPacManLocation().row()));
        if (state.getPacManLocation().column() > state.getColumns()) {
            state.setPacManLocation(new Location(1, state.getPacManLocation().row()));
        }

        state.setSymbol(Symbols.PACMAN_RIGHT, state.getPacManLocation().column(), state.getPacManLocation().row());
    }
}
