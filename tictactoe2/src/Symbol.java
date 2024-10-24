public enum Symbol {
    X('X'),
    O('O'),
    EMPTY('-');

    private final char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
