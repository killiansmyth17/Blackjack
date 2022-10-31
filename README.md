# Blackjack

An exercise on OOD principles for personal Java practice

## Complete:
- Created base class for a "stack" of cards named CardList with getters/setters, operations for drawing/removing cards, etc.
- Created Card class that uses enums for Rank and Suit. Each Rank contains a label/value pair (e.g. "Queen", 12)
- Created Deck class that extends CardList with extra operation for shuffling. All cards are "spawned" from Deck constructors to be later distributed.
- Created Hand class that extends CardList
- Created Blackjack game itself in Blackjack class
- BlackjackHand class extends Hand class (contains useful methods and data for blackjack player/dealer hands)

## To-do:
- Clean up Blackjack code (lots of repeat code for hits especially)
- Use card package to write another card game (poker? go fish? etc.)
- Create Blackjack with UI
- Multiplayer Blackjack?
