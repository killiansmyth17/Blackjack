import blackjack.Card;
import blackjack.Suit;
import blackjack.Rank;

public class Blackjack {
    public static void main(String args[]) {
        Card card = new Card(Suit.HEARTS, Rank.QUEEN);
        card.print();
    }
}