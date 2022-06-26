package blackjack.human;

import blackjack.card.Card;
import blackjack.card.Suit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {
    Participant human;

    @AfterEach
    void tearDown() {
        human = null;
    }

    /**
     *
     */
    @Test
    void construct() {
        human = new Dealer();
        assertThat(human).isInstanceOf(Dealer.class);

        human = new Player("yena");
        assertThat(human).isInstanceOf(Player.class)
                .isEqualTo(new Player("yena"));

        assertThatThrownBy(() -> new Player("Dealer"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addCard_getCardsString() {
        //given
        human = new Player("yena");

        //when
        human.addCard(new Card(4, Suit.HEART));
        human.addCard(new Card(12, Suit.DIAMOND));

        //then
//        System.out.println(human.getCardsString());
        assertThat(human.getCardsString()).isEqualTo("[(4, HEART), (Q, DIAMOND)]");
    }

    @Test
    void getName() {
        assertThat(new Dealer().getName()).isEqualTo("Dealer");
        assertThat(new Player("yena").getName()).isEqualTo("yena");
    }

    @Test
    void getScore() {
        //given
        human = new Player("yena");

        //when
        human.addCard(new Card(4, Suit.HEART));
        human.addCard(new Card(12, Suit.DIAMOND));

        //then
        assertThat(human.getScore()).isEqualTo(14);
    }

    @Test
    void firstMoney_lastMoney() {
        human = new Dealer();
        assertThat(human.getFirstMoney()).isEqualTo(0);
        human.setLastMoney(1000);
        assertThat(human.getFirstMoney()).isEqualTo(0);
        assertThat(human.getLastMoney()).isEqualTo(1000);

        human = new Player("yena", 23);
        assertThat(human.getFirstMoney()).isEqualTo(23);
        human.setLastMoney(1);
        assertThat(human.getFirstMoney()).isEqualTo(23);
        assertThat(human.getLastMoney()).isEqualTo(1);
    }

    @Test
    void noMoreWantCard() {
        human = new Dealer();
        assertThat(human.getWantMoreCard()).isTrue();

        human.noMoreWantCard();
        assertThat(human.getWantMoreCard()).isFalse();
    }

    @Test
    void lifeCycle() {
        human = new Dealer();
        assertThat(human.getLife()).isTrue();

        human.addCard(new Card(4, Suit.HEART));
        human.addCard(new Card(12, Suit.DIAMOND));
        assertThat(human.getLife()).isTrue();


        human.addCard(new Card(12, Suit.CLUB));
        assertThat(human.getLife()).isFalse();
    }
}
