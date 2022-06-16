package blackjack.human;

import blackjack.card.Card;
import blackjack.card.Cards;

import java.util.Objects;

public class Participant {
    public static final String DEALER_NAME = "Dealer";
    public static final String ERROR_WRONG_NAME = "참가자 이름은 딜러가 될 수 없습니다.";
    protected final String name;
    protected final Cards cards;
    protected int money;

    protected Participant(String name) {
        this(name, 0);
    }

    protected Participant(String name, int money) {
        this.name = name;
        cards = new Cards();
        this.money = money;
    }

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return cards.getScore();
    }

    public String getCardsString() {
        return cards.toString();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
