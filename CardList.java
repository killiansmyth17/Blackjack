//Base class for a "stack" of cards. Note that it makes more sense to store them in an ArrayList
//rather than an actual stack data type
package cards;

import java.util.List;
import java.util.ArrayList;
import cards.Card;

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

    public String getSuit(int i) {
        return this.getCard(i).getSuit();
    }

    public String getRank(int i) {
        return this.getCard(i).getRank();
    }

    public int getValue(int i) {
        return this.getCard(i).getValue();
    }

    public boolean addCard(Card card) {
        return this.cards.add(card);
    }

    public Card removeCard(int i) {
        return this.cards.remove(i);
    }

    //Dump one CardList into another CardList
    //The dumping CardList will be emptied into the receiving CardList
    public void dumpCards(CardList cardlist) {
        for(int i = 0; i<cardlist.getSize(); i++) {
            this.addCard(cardlist.getCard(i));
        }
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