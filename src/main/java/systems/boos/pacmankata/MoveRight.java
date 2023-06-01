package systems.boos.pacmankata;

public class MoveRight {
    public void execute(GameState state) {
        state.placeSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManColumn(state.getPacManColumn() + 1);
        if (state.getPacManColumn() > state.getColumns()) {
            state.setPacManColumn(1);
        }

        state.placeSymbol(Symbols.PACMAN_RIGHT, state.getPacManColumn(), state.getPacManRow());
    }
}
