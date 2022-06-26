package blackjack.human;

import blackjack.card.Card;
import blackjack.card.Cards;

import java.util.Objects;

public class Participant {
    public static final String DEALER_NAME = "Dealer";
    public static final String ERROR_WRONG_NAME = "참가자 이름은 딜러가 될 수 없습니다.";
    protected final String name;
    protected final Cards cards;
    protected int firstMoney;
    protected int lastMoney;
    protected boolean wantMoreCard;
    protected boolean life;

    protected Participant(String name) {
        this(name, 0);
    }

    protected Participant(String name, int firstMoney) {
        this.name = name;
        cards = new Cards();
        this.firstMoney = firstMoney;
        lastMoney = firstMoney;
        wantMoreCard = true;
        life = true;
    }

    public void addCard(Card card) {
        cards.addCard(card);
        validateLife();
    }

    public String getCardsString() {
        return cards.toString();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return cards.getScore();
    }

    public int getFirstMoney() {
        return firstMoney;
    }

    public int getLastMoney() {
        return lastMoney;
    }

    public void setLastMoney(int lastMoney) {
        this.lastMoney = lastMoney;
    }

    public void noMoreWantCard() {
        wantMoreCard = false;
    }

    public boolean getWantMoreCard() {
        return wantMoreCard;
    }

    public boolean getLife() {
        return life;
    }

    private void validateLife() {
        if (cards.getScore() > 21) {
            life = false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
