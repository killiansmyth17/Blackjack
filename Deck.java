package blackjack;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import blackjack.Card;
import blackjack.Suit;
import blackjack.Rank;

    //figure out good way to store deck (and a better way to write notes)

    //needs: 

    // - Cards
        // - probably need a card class
            // - Store suit and value
                // - enum? string? int?
        // - need to figure out data structure to store cards that can track card position, shuffle, add/remove
            // - Probably want position stored in the deck data structure rather than in the card itself
            // - Probably want linear data structure
            // - Probably want to use Collection interface since a better data structure could be found later
            // - LinkedList can track position & easily add/remove, shuffling would be difficult
            // - Stack can easily track position and add/remove to/from top, shuffling would be... impossible?
            // - ArrayList can extremely easily track position and add/remove, shuffling is easier
            // - Starting to think the only real difference between linear data structures is the shuffling 

    // - Methods
        // - populate deck 
            // - construct full deck with all 52 cards
            // - shuffle
        // - remove card from top of deck (deal cards)
        // - shuffle cards
            // - research shuffling algorithms
        // - probably add card from table
            // - how are cards added to decks in a real casino? they probably do things to combat counting
        // - can probably just entirely repopulate deck when game finishes rather than add missing cards back
            // - i.e. `deck = new Deck();`, old deck gets garbage collected
            // - i.e. `hand = new Hand();`, old hands get garbage collected
            // - re-adding missing cards may save computation (and it sounds kinda cool from a programming perspective)
                // - probably negligible saving and confusing for maintenance (sounds REALLY cool though)
            // - wait this method would be part of the blackjack class, not deck class

public class Deck {
    private List<Card> deck;
    
    public Deck() {
        Suit[] allSuits = Suit.values();
        Rank[] allRanks = Rank.values();
        this.deck = new ArrayList<Card>(allSuits.length * allRanks.length);

        for(Suit suit : allSuits) {
            for(Rank rank : allRanks) {
                this.deck.add(new Card(suit, rank));
            }
        }
    }

    public int getSize() {
        return this.deck.size();
    }

    public Card getCard(int i) {
        return this.deck.get(i);
    }

    public void removeCard(int i) {
        this.deck.remove(i);
    }
    
    public Card draw() {
        //top of deck is end of ArrayList
        int last = this.getSize()-1;
        Card card = this.getCard(last);
        this.removeCard(last);

        return card;
    }

    public void shuffle() {
        //iterate from the end of the List to the front
        //at each index, swap with random other index
        Collections.shuffle(this.deck);
    }

    public String toString() {
        String deckString = "";
        int size = this.getSize();
        for(int i = 0; i<size-1; i++) {
            deckString+=this.getCard(i).toString() + "\n";
        }
        deckString += this.getCard(size-1).toString();

        return deckString;
    }
}