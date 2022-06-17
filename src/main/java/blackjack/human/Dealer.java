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

    public void changeHiddenStatusSecondCard() {
        cards.changeHiddenStatusSecondCard();
    }

    public void moreCardAutoPlay() {
        if (getScore() <= 16) {
            this.addCard(CardSupplier.getCard());
        }
        else {
            noMoreWantCard();
        }

        OutputView.dealerAutoPlayMessage(getScore());
    }
}
