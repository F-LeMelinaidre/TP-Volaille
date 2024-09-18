package asset;

public enum SimpleTableBorder {
    H("─"),
    V("│"),
    TOP_LEFT("┌"),
    TOP_RIGHT("┐"),
    MIDDLE_TOP("┬"),
    MIDDLE_LEFT("├"),
    MIDDLE("┼"),
    MIDDLE_RIGHT("┤"),
    MIDDLE_BOTTOM("┴"),
    BOTTOM_LEFT("└"),
    BOTTOM_RIGHT("┘");

    private final String symbol;

    SimpleTableBorder(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
