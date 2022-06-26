package blackjack.human;

import blackjack.card.Card;
import blackjack.card.CardSupplier;
import blackjack.view.OutputView;

public class Dealer extends Participant {
    public Dealer() {
        super(DEALER_NAME);
    }

    public void changeHiddenStatusSecondCard() {
        cards.changeHiddenStatusSecondCard();
    }
}
