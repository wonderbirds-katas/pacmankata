package systems.boos.pacmankata;

public class Printer {
    public String print(GameState state) {
        var resultBuilder = new StringBuilder();

        for (int row = 1; row <= state.getRows(); row++) {
            StringBuilder rowString = new StringBuilder();
            for (int column = 1; column <= state.getColumns(); column++) {
                rowString.append(state.getSymbol(column, row));
            }
            rowString.append("\n");
            resultBuilder.append(rowString);
        }

        return resultBuilder.toString();
    }
}
