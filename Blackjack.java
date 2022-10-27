import blackjack.Deck;
import blackjack.Card;

public class Blackjack {
    public static void main(String args[]) {
        Deck deck = new Deck();
        Card card = deck.drawCard();

        System.out.println("Drew card: " + card.toString());
        System.out.println("\nDeck:");
        System.out.println(deck.toString());
        System.out.println("\nShuffled deck:");
        deck.shuffle();
        System.out.println(deck.toString());

        card = deck.drawCard();
        System.out.println("\nDrew card: \n" + card.toString());
    }
}