package systems.boos.pacmankata;

public class MoveDown {
    public void execute(GameState state) {
        state.placeSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManRow(state.getPacManRow() + 1);
        if (state.getPacManRow() > state.getRows()) {
            state.setPacManRow(1);
        }

        state.placeSymbol(Symbols.PACMAN_DOWN, state.getPacManColumn(), state.getPacManRow());
    }
}
