package blackjack.card;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Card {
    private static final String ERROR_WRONG_NUMBER = "잘못된 숫자가 입력됐습니다.";
    private static final String ERROR_WRONG_SUIT = "잘못된 무늬가 입력됐습니다.";
    public static final int NUMBER_LOWER_LIMIT = 1;
    public static final int NUMBER_UPPER_LIMIT = 13;
    public static final int CALCULATE_UPPER_LIMIT = 10;
    private final int number;
    private final Suit suit;
    private boolean hiddenStatus;

    public Card() {
        this(new Random().nextInt(NUMBER_UPPER_LIMIT) + NUMBER_LOWER_LIMIT,
                Arrays.asList(Suit.values()).get(new Random().nextInt(4)));
    }

    public Card(int number, String suit) {
        this(number, stringToValidSuit(suit));
    }

    public Card(int number, Suit suit) {
        this.number = checkValidNumber(number);
        this.suit = suit;
        hiddenStatus = false;
    }

    public int getNumberForCalculate() {
        return Math.min(CALCULATE_UPPER_LIMIT, number);
    }

    //Cards에서 2번 카드 상태 변경을 List<>의 set/put으로 해야되므로
    //void 메서드가 아닌 Card를 return하게끔 할수밖에 없었다
    public Card changeHiddenStatus() {
        Card editCard = this;
        editCard.hiddenStatus = !editCard.hiddenStatus;
        return editCard;
    }

    private static int checkValidNumber(int input) {
        if (input < NUMBER_LOWER_LIMIT || input > NUMBER_UPPER_LIMIT) {
            throw new IllegalArgumentException(ERROR_WRONG_NUMBER);
        }
        return input;
    }

    private static Suit stringToValidSuit(String input) {
        return Arrays.stream(Suit.values())
                .filter(suit -> suit.name().equals(input.toUpperCase()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_WRONG_SUIT));
    }

    private String numberToString(int number) {
        List<String> replaceNumberToString = Arrays.asList("A", "J", "Q", "K");
        if (number == 1) {
            return replaceNumberToString.get(0);
        }
        if (number > CALCULATE_UPPER_LIMIT) {
            return replaceNumberToString.get(number - CALCULATE_UPPER_LIMIT);
        }

        return Integer.toString(number);
    }

    @Override
    public String toString() {
        if (hiddenStatus) {
            return "(HIDDEN CARD)";
        }

        return String.format("(%s, %s)", numberToString(number), suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && suit == card.suit;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(number, suit);
//    }
}
