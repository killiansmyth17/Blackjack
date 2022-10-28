package cards;

import java.util.Collections;
import cards.Card;
import cards.Suit;
import cards.Rank;

//only Deck should be able to "spawn" cards
//all cards should originate from a Deck
public class Deck extends CardList {
    final private Suit[] allSuits = Suit.values();
    final private Rank[] allRanks = Rank.values();

    //single deck constructor
    public Deck() {
        super();

        for(Suit suit : this.allSuits) {
            for(Rank rank : this.allRanks) {
                super.addCard(new Card(suit, rank));
            }
        }
    }

    //multideck constructor
    public Deck(int numDecks) {
        super();

        //create deck with numDecks decks (e.g. 6 decks for 6-deck blackjack)
        for(int i = 0; i<numDecks; i++) {
            for(Suit suit : this.allSuits) {
                for(Rank rank : this.allRanks) {
                    super.addCard(new Card(suit, rank));
                }
            } 
        }
    }

    public void shuffle() {
        //iterate from the end of the List to the front
        //at each index, swap with random other index
        Collections.shuffle(super.getCards());
    }

}