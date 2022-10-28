package cards;

public enum Suit {
    CLUBS("Clubs"),
    SPADES("Spades"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds");

    public final String label;

    private Suit(String label) {
        this.label = label;
    }
}