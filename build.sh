BASEDIR=$(dirname "$0")
javac -d $BASEDIR Deck.java Card.java Suit.java Rank.java
javac Blackjack.java
