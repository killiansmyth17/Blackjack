package cards;

import java.util.Collections;
import cards.Card;
import cards.Suit;
import cards.Rank;

//only Deck should be able to "spawn" cards
//all cards should originate from a Deck
public class Deck extends CardList {
    
    public Deck() {
        super();

        final Suit[] allSuits = Suit.values();
        final Rank[] allRanks = Rank.values();

        for(Suit suit : allSuits) {
            for(Rank rank : allRanks) {
                super.addCard(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        //iterate from the end of the List to the front
        //at each index, swap with random other index
        Collections.shuffle(super.getCards());
    }

}