package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CardTest {
    @Test
    void construct_equals() {
        Card card = new Card(3, "spade");
        assertThat(card).isEqualTo(new Card(3, "Spade"));
    }

    @Test
    void random_making() {
        Card card = new Card();
        System.out.println(card);
    }

    @Test
    void illegalNumber_illegalSuit() {
        assertThatThrownBy(() -> new Card(1, "star")).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Card(0, "club")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Card(14, "club")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void to_string() {
        Card card = new Card(3, "spade");
        assertThat(card.toString()).isEqualTo("(3, SPADE)");

        card = new Card(1, Suit.HEART);
        assertThat(card.toString()).isEqualTo("(A, HEART)");

        card = new Card(11, "diAMOnd");
        assertThat(card.toString()).isEqualTo("(J, DIAMOND)");

        card = card.changeHiddenStatus();
        assertThat(card.toString()).isEqualTo("(HIDDEN CARD)");
    }

    @Test
    void getNumberForCalculate() {
        assertThat(new Card(1, Suit.HEART).getNumberForCalculate()).isEqualTo(1);
        assertThat(new Card(10, Suit.HEART).getNumberForCalculate()).isEqualTo(10);
        assertThat(new Card(11, Suit.HEART).getNumberForCalculate()).isEqualTo(10);
        assertThat(new Card(12, Suit.HEART).getNumberForCalculate()).isEqualTo(10);
    }
}
