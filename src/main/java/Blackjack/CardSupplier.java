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

    public Card getCard() {
        if (suppliedCards.size() >= CARD_TYPE_MAX) {
            throw new IllegalArgumentException(MESSAGE_ALL_CARD_SUPPLIED);
        }

        Card result;
        do {
            result = new Card();
        } while (suppliedCards.contains(result));

        suppliedCards.add(result);

        return result;
    }

    public Card getHiddenCard() {
        Card result = getCard();

        result.changeHiddenStatus();

        return result;
    }
}
