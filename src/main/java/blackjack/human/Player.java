package blackjack.human;

public class Player extends Participant {
    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int money) {
        super(name, money);
        if (name == DEALER_NAME) {
            throw new IllegalArgumentException(ERROR_WRONG_NAME);
        }
    }
}
