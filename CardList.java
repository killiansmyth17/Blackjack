//Base class for a "stack" of cards. Note that it makes more sense to store them in an ArrayList
//rather than an actual stack data type
package blackjack;

import java.util.List;
import java.util.ArrayList;
import blackjack.Card;

public class CardList {
    private List<Card> cards;

    protected CardList() {
        cards = new ArrayList<Card>();
    }

    public int getSize() {
        return this.cards.size();
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public boolean addCard(Card card) {
        return this.cards.add(card);
    }

    public Card removeCard(int i) {
        return this.cards.remove(i);
    }
    
    public Card drawCard() {
        //top of deck is end of ArrayList
        int last = this.getSize()-1;
        return this.removeCard(last);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String toString() {
        String cardsString = "";
        int size = this.getSize();
        for(int i = 0; i<size-1; i++) {
            cardsString+=this.getCard(i).toString() + "\n";
        }
        cardsString += this.getCard(size-1).toString();

        return cardsString;
    }
}