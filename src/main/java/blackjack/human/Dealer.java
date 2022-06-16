package blackjack.human;

import blackjack.card.CardSupplier;
import blackjack.view.OutputView;

public class Dealer extends Participant {
    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(int money) {
        super(DEALER_NAME, money);
    }

    public void moreCardAutoPlay() {
        if (getScore() <= 16) {
            this.addCard(CardSupplier.getCard());
        }

        OutputView.dealerAutoPlayMessage(getScore());
    }
}
