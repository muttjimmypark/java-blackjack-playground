package Blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardSupplierTest {
    CardSupplier cardSupplier;

    @BeforeEach
    void setUp() {
        cardSupplier = new CardSupplier();
    }

    @Test
    void getCard() {
        String test = cardSupplier.getCard().getInfo();
        System.out.println(test);
        assertThat(test).isNotEqualTo("(HIDDEN CARD)");
    }

    @Test
    void getHiddenCard() {
        String test = cardSupplier.getHiddenCard().getInfo();
        System.out.println(test);
        assertThat(test).isEqualTo("(HIDDEN CARD)");
    }

    @AfterEach
    void tearDown() {
        cardSupplier = null;
    }
}
