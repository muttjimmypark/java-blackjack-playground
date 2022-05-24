package Blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    Card card1 = new Card(1, Suit.SPADE);
    Card card2 = new Card(11, Suit.HEART);
    Card card3 = new Card(12, Suit.DIAMOND);
    Card card4 = new Card(13, Suit.CLUB);

    @Test
    void constructor() {
        card1 = new Card(2, Suit.HEART);
        assertThat(card1).isEqualTo(new Card(2, Suit.HEART));
    }

    @Test
    void constructor_random() {
        card1 = new Card();
        System.out.println(card1.getInfo());
    }

    @Test
    void getInfo() {
        assertThat(card1.getInfo()).isEqualTo("(A, SPADE)");
        assertThat(card2.getInfo()).isEqualTo("(J, HEART)");
        assertThat(card3.getInfo()).isEqualTo("(Q, DIAMOND)");
        assertThat(card4.getInfo()).isEqualTo("(K, CLUB)");

        card1.changeHiddenStatus();
        assertThat(card1.getInfo()).isEqualTo("(HIDDEN CARD)");
    }

    @Test
    void getNumberForCalculate() {
        assertThat(card1.getNumberForCalculate()).isEqualTo(1);
        assertThat(card2.getNumberForCalculate()).isEqualTo(10);
        assertThat(card3.getNumberForCalculate()).isEqualTo(10);
        assertThat(card4.getNumberForCalculate()).isEqualTo(10);
    }
}
