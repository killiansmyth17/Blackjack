BASEDIR=$(dirname "$0")
javac -d $BASEDIR CardList.java Deck.java Hand.java Card.java Suit.java Rank.java
javac Blackjack.java
