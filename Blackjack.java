import java.util.Scanner;
import cards.Deck;
import blackjack.BlackjackHand;

public class Blackjack {

    enum WinState {
        WIN,
        DRAW,
        LOSE
    }

    //game state machine
    enum GameState {
        START,
        PLAYERPLAY,
        DEALERPLAY,
        COMPARE,
        END
    }

    //state machine
    public static void main(String args[]) {
        stateMachine();
    }

    public static void stateMachine() {
        //6-deck blackjack
        Deck deck = new Deck(6);
        BlackjackHand dealer = new BlackjackHand();
        BlackjackHand player = new BlackjackHand();

        GameState state = GameState.START;
        while(state != GameState.END) {
            if(state == GameState.START) {
                state = start(deck, player, dealer);
            }

            if(state == GameState.PLAYERPLAY) {
                state = playPhase(deck, player);
            }

            if(state == GameState.DEALERPLAY) {
                state = dealerPlayPhase(deck, dealer);
            }

            if(state == GameState.COMPARE) {
                state = compare(player, dealer);
            }
        }
    }
    
    public static GameState start(Deck deck, BlackjackHand player, BlackjackHand dealer) {
        deck.shuffle();

        //boolean playing = true;

        //first deal
        System.out.print("Player draws card: ");
        player.addCard(deck.drawCard(true));
        System.out.println("Player hand value: " + getValue(player) + "\n");
        System.out.print("Dealer draws card: ");
        dealer.addCard(deck.drawCard(true));
        System.out.println("Dealer hand value: " + getValue(dealer) + "\n");

        //second deal
        System.out.print("Player draws card: ");
        player.addCard(deck.drawCard(true));
        System.out.println("Player hand value: " + getValue(player) + "\n");
        System.out.print("Dealer draws a card face down.\n");
        dealer.addCard(deck.drawCard(false)); //face down, no print

        boolean playerNat = checkNatural(player);
        boolean dealerNat = checkNatural(dealer);

        if(playerNat && dealerNat) {
            System.out.println("Two natural blackjacks.");
            return endGame(WinState.DRAW);
        }
        else if(playerNat) {
            System.out.println("Natural blackjack.");
            return endGame(WinState.WIN);
        }
        else if(dealerNat) {
            System.out.println("Natural blackjack.");
            return endGame(WinState.LOSE);
        }
        else {
            return GameState.PLAYERPLAY;
        }
    }

    public static GameState playPhase(Deck deck, BlackjackHand player) {
        Scanner sc = new Scanner(System.in);
        boolean stand = false;
        
        System.out.println("\nPlayer hand value: " + getValue(player));

        while(player.getLowValue() < 21 && player.getHighValue() != 21 && !stand) {
            System.out.println("Hit or stand? (Hit: 0 | Stand: 1)");

            if(sc.nextInt()==0) {
                System.out.print("\nPlayer draws card: ");
                player.addCard(deck.drawCard(true));
                
                System.out.println("Player hand value: " + getValue(player));
            }
            else {
                stand = true;
            }
        }

        if(player.getLowValue() > 21) {
            return endGame(WinState.LOSE);
        }

        return GameState.DEALERPLAY;
    }

    public static GameState dealerPlayPhase(Deck deck, BlackjackHand dealer) {
        System.out.println("\nDealer turns over card to reveal: " + dealer.toString(1));
        System.out.println("Dealer hand value: " + getValue(dealer));

        if(dealer.getHighValue() >= 17 && dealer.getHighValue() <= 21) {
            return GameState.COMPARE;
        }

        while(dealer.getLowValue() < 21) {
            System.out.print("\nDealer draws card: ");
            dealer.addCard(deck.drawCard(true));
            System.out.println("Dealer hand value: " + getValue(dealer));
            
            int highValue = dealer.getHighValue();
            int lowValue = dealer.getLowValue();
            if(highValue >= 17 && highValue <= 21) {
                return GameState.COMPARE;
            }

            if(lowValue >= 17 && lowValue <= 21) {
                return GameState.COMPARE;
            }
        }

        return endGame(WinState.WIN);
    }

    public static GameState compare(BlackjackHand player, BlackjackHand dealer) {
        int playerVal = (player.getHighValue() > 21) ? player.getLowValue() : player.getHighValue();
        int dealerVal = (dealer.getHighValue() > 21) ? dealer.getLowValue() : dealer.getHighValue();

        if(playerVal > dealerVal) {
            endGame(WinState.WIN);
        } 

        if(playerVal < dealerVal) {
            endGame(WinState.LOSE);
        }

        if(playerVal == dealerVal) {
            endGame(WinState.DRAW);
        }

        return GameState.END;
    }

    //check hand for natural blackjack (Ace and a 10)
    public static boolean checkNatural(BlackjackHand hand) {
        if(hand.getHighValue() == 21) {
            return true;
        }

        return false;
    }

    public static GameState endGame(WinState state) {
        if(state == WinState.WIN) {
            System.out.println("You won.");
        }

        else if (state == WinState.DRAW) {
            System.out.println("You drew.");
        }

        else { //state == WinState.LOSE
            System.out.println("You lost.");
        }

        return GameState.END;
    }

    public static String getValue(BlackjackHand hand) {
        int highValue = hand.getHighValue();
        int lowValue = hand.getLowValue();

        if(highValue == lowValue) {
            return highValue + "";
        }

        if(highValue > 21) {
            return lowValue + "";
        }

        return highValue + " or " + lowValue;
    }
}