package systems.boos.pacmankata;

public enum Symbols {
    DOT("."), PACMAN_UP("V"), EMPTY_SPACE(" "), PACMAN_DOWN("A"), PACMAN_RIGHT("<"), PACMAN_LEFT(">");

    private final String printedRepresentation;

    Symbols(String printedRepresentation) {
        this.printedRepresentation = printedRepresentation;
    }

    @Override
    public String toString() {
        return printedRepresentation;
    }
}
