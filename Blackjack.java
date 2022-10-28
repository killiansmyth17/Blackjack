import cards.Deck;
import cards.Hand;

public class Blackjack {
    public static void main(String args[]) {
        //6-deck blackjack
        Deck deck = new Deck(6);
        deck.shuffle();

        System.out.println(deck.toString());
        System.out.println(deck.getSize());
    }
}