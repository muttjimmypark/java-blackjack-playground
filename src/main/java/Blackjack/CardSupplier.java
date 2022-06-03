package Blackjack;

import java.util.ArrayList;
import java.util.List;

public class CardSupplier {
    private static final int CARD_TYPE_MAX = 52;
    private static final String MESSAGE_ALL_CARD_SUPPLIED = "카드가 모두 소진되었습니다.";
    private final List<Card> suppliedCards;

    public CardSupplier() {
        suppliedCards = new ArrayList<>();
    }

    private Card getCard(LambdaReturnBoolean lambdaReturnBoolean) {
        //checkSupplyIsOver()
        if (suppliedCards.size() >= CARD_TYPE_MAX) {
            throw new IllegalArgumentException(MESSAGE_ALL_CARD_SUPPLIED);
        }

        //makeNotDuplicatedCard()
        Card result;
        do {
            result = new Card();
        } while (suppliedCards.contains(result));

        //
        if (lambdaReturnBoolean.condition()) {
            result.changeHiddenStatus();
        }
        suppliedCards.add(result);
        return result;
    }

    public Card getOpenCard() {
        return getCard(() -> false);
    }

    public Card getHiddenCard() {
        return getCard(() -> true);
    }
}
