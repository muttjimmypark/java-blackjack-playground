package blackjack.card;

import java.util.ArrayList;
import java.util.List;

public class CardSupplier {
    public static final int THE_NUMBER_OF_CASES = 52;
    public static final String ERROR_SUPPLING_IS_DONE = "카드가 모두 소진되었습니다.";
    List<Card> suppliedCard;

    public CardSupplier() {
        suppliedCard = new ArrayList<>();
    }

    public Card getCard() {
        if (suppliedCard.size() >= THE_NUMBER_OF_CASES) {
            throw new IllegalArgumentException(ERROR_SUPPLING_IS_DONE);
        }

        Card card;
        do {
            card = new Card();
        } while (suppliedCard.contains(card));

        suppliedCard.add(card);
        return card;
    }
}
