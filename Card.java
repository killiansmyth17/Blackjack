package blackjack;

public class Card {
    public final Suit suit;
    public final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void print() {
        System.out.println("The " + rank.label + " of " + suit.label);
    }
}