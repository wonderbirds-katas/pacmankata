package systems.boos.pacmankata;

public class Printer {
    public String print(GameState state) {
        var resultBuilder = new StringBuilder();

        for (int row = 0; row < state.getRows(); row++) {
            StringBuilder rowString = new StringBuilder();
            for (int column = 0; column < state.getColumns(); column++) {
                rowString.append(state.getSymbolAt(column, row));
            }
            rowString.append("\n");
            resultBuilder.append(rowString);
        }

        return resultBuilder.toString();
    }
}
