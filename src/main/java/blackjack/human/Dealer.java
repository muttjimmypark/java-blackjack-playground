package blackjack.human;

public class Dealer extends Participant {
    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(int money) {
        super(DEALER_NAME, money);
    }
}
