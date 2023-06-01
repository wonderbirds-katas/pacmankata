package systems.boos.pacmankata;

public class MoveLeft {
    public void execute(GameState state) {
        state.placeSymbol(Symbols.EMPTY_SPACE, state.getPacManColumn(), state.getPacManRow());

        state.setPacManColumn(state.getPacManColumn() - 1);
        if (state.getPacManColumn() < 1) {
            state.setPacManColumn(state.getColumns());
        }

        state.placeSymbol(Symbols.PACMAN_LEFT, state.getPacManColumn(), state.getPacManRow());
    }
}
