package Blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final List<Card> cards;
    int score;

    public Cards() {
        cards = new ArrayList<>();
    }

    public Cards(List<Card> cards) {
        this.cards = cards;
    }
}
