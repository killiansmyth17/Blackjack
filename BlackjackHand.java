package blackjack;

import cards.Hand;
import cards.Card;

public class BlackjackHand extends Hand {

    //two values
    private int highValue = 0; //Ace valued at 11
    private int lowValue = 0; //Ace valued at 1

    public BlackjackHand() {
        super();
    }

    @Override
    public int getValue(int i) {
        int value = super.getValue(i); 
        return (value > 10) ? 10 : value; //cap value at 10
    }

    //add card and change value of hand
    @Override
    public boolean addCard(Card card) {
        int value = this.capValue(card.getValue());

        //if highValue == lowValue, an ace hasn't been accounted for before
        //only need to account for ace once, because (2*11)>21
        if(value == 1 && this.highValue == this.lowValue) {
            this.highValue += 11;
            this.lowValue += 1;
        }

        else {
            this.highValue += value;
            this.lowValue += value;
        }

        return super.addCard(card);
    }

    //10s, Jacks, Queens and Kings are all valued at 10
    private int capValue(int value) {
        return (value > 10) ? 10 : value;
    }

    public int getHighValue() {
        return this.highValue;
    }
    
    public int getLowValue() {
        return this.lowValue;
    }
}