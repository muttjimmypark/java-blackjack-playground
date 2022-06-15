package blackjack.card;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {
    Cards cards;

    @BeforeEach
    void setUp() {
        cards = new Cards();
        cards.addCard(new Card(1, "club"));
        cards.addCard(new Card(2, "heart"));
    }

    @Test
    void addCard_toString() {
        assertThat(cards.toString()).isEqualTo("[(A, CLUB), (2, HEART)]");
    }

    @Test
    void changeHiddenStatusSecondCard() {
        cards.changeHiddenStatusSecondCard();
        assertThat(cards.toString()).isEqualTo("[(A, CLUB), (HIDDEN CARD)]");

        cards.addCard(new Card(3, Suit.SPADE));
        assertThat(cards.toString()).isEqualTo("[(A, CLUB), (HIDDEN CARD), (3, SPADE)]");

        cards.changeHiddenStatusSecondCard();
        assertThat(cards.toString()).isEqualTo("[(A, CLUB), (2, HEART), (3, SPADE)]");
    }

    @Test
    void getScore() {
        assertThat(cards.getScore()).isEqualTo(13);

        cards.addCard(new Card(11, "diamond"));
        assertThat(cards.getScore()).isEqualTo(13);
    }

    @AfterEach
    void tearDown() {
        cards = null;
    }
}
