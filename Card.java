package cards;

public class Card {
    public final Suit suit;
    public final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return this.suit.label;
    }

    public String getRank() {
        return this.rank.label;
    }

    public int getValue() {
        return this.rank.value;
    }

    public String toString() {
        return "The " + this.getRank() + " of " + this.getSuit();
    }
}