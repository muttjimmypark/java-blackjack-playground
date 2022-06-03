package Blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Card {
    private static final int CARD_NUMBER_MIN = 1;
    private static final int CARD_NUMBER_MAX = 13;
    public static final int CARD_NUMBER_CALCULATE_MAX = 10;
    private static final String MESSAGE_ILLEGAL_CARD_NUMBER = "잘못된 카드숫자 입력입니다.";
    private final int number;
    private final Suit suit;
    private boolean hiddenStatus = false;

    public Card(int number, Suit suit) {
        if (number < CARD_NUMBER_MIN || number > CARD_NUMBER_MAX) {
            throw new IllegalArgumentException(MESSAGE_ILLEGAL_CARD_NUMBER);
        }
        this.number = number;
        this.suit = suit;
    }

    public Card() {
        this(new Random().nextInt(CARD_NUMBER_MAX) + CARD_NUMBER_MIN,
                Arrays.asList(Suit.values()).get(new Random().nextInt(4)));
    }

    public String getInfo() {
        List<String> overTen = Arrays.asList("J", "Q", "K");
        String numberToString = Integer.toString(number);

        if (number == CARD_NUMBER_MIN) {
            numberToString = "A";
        }
        if (number > CARD_NUMBER_CALCULATE_MAX) {
            numberToString = overTen.get(number - CARD_NUMBER_CALCULATE_MAX -1);
        }

        if (hiddenStatus) {
            return "(HIDDEN CARD)";
        }
        return String.format("(%s, %s)", numberToString, suit);
    }

    public void changeHiddenStatus() {
        hiddenStatus = !hiddenStatus;
    }

    public int getNumberForCalculate() {
        return Math.min(number, CARD_NUMBER_CALCULATE_MAX);
    }

    @Override
    public String toString() {
        List<String> overTen = Arrays.asList("J", "Q", "K");
        String numberToString = Integer.toString(number);

        if (number == CARD_NUMBER_MIN) {
            numberToString = "A";
        }
        if (number > CARD_NUMBER_CALCULATE_MAX) {
            numberToString = overTen.get(number - CARD_NUMBER_CALCULATE_MAX -1);
        }

        if (hiddenStatus) {
            return "(HIDDEN CARD)";
        }
        return String.format("(%s, %s)", numberToString, suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }
}
