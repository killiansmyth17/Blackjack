import blackjack.Deck;
import blackjack.Card;

public class Blackjack {
    public static void main(String args[]) {
        Deck deck = new Deck();
        Card card = deck.draw();

        System.out.println("Drew card: " + card.toString());
        System.out.println("\nDeck:");
        System.out.println(deck.toString());
    }
}