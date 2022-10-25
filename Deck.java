package blackjack;

public class Deck {
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

}