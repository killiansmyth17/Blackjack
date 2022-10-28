import cards.Deck;
import cards.Hand;

public class Blackjack {
    public static void main(String args[]) {
        Deck deck = new Deck();
        deck.shuffle();

        Hand hand = new Hand();
        hand.addCard(deck.drawCard());

        System.out.println(hand.toString());
        
    }
}