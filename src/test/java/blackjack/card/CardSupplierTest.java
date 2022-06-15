package blackjack.card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CardSupplierTest {
    @Test
    void getCard() {
        CardSupplier cardSupplier = new CardSupplier();
        List<Card> testCards = new ArrayList<>();
        Card testCard;

        for (int i = 0; i < CardSupplier.THE_NUMBER_OF_CASES; i++) {
            testCard = cardSupplier.getCard();
            assertThat(testCards.contains(testCard)).isFalse();
            testCards.add(testCard);
        }

        assertThatThrownBy(() -> cardSupplier.getCard()).isInstanceOf(IllegalArgumentException.class);
    }
}
