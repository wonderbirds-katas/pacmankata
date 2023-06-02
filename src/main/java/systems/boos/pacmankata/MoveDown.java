package systems.boos.pacmankata;

public class MoveDown {
    public void execute(GameState state) {
        state.setSymbol(Symbols.EMPTY_SPACE, state.getPacManLocation().column(), state.getPacManLocation().row());

        state.setPacManLocation(new Location(state.getPacManLocation().column(), state.getPacManLocation().row() + 1));
        if (state.getPacManLocation().row() > state.getRows()) {
            state.setPacManLocation(new Location(state.getPacManLocation().column(), 1));
        }

        state.setSymbol(Symbols.PACMAN_DOWN, state.getPacManLocation().column(), state.getPacManLocation().row());
    }
}
