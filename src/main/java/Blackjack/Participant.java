package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Participant {
    private final String name;
    private final List<Card> cards;
    private int score;
    private final int betMoney;
    private final int calculatedMoney;
    private ParticipantScore participantStatus;

    protected Participant(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
        cards = new ArrayList<>();
        calculatedMoney = betMoney;
        score = 0;
        participantStatus = ParticipantScore.UNDER21;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getCardsMessage() {
        return String.format("%s의 현재 카드 : %s", name, cardsToString());
    }

    private List<String> cardsToString() {
        return cards.stream()
                .map(Card::getInfo)
                .collect(Collectors.toList());
    }

    public ParticipantScore checkParticipantStatus() {
        List<Integer> cardNumbers = cards.stream()
                .map(Card::getNumberForCalculate)
                .distinct()
                .collect(Collectors.toList());

        for (Integer cardNumber : cardNumbers) {
            score += cardNumber;
        }

        if (cardNumbers.stream()
                .anyMatch(cardNumber -> cardNumber == 1)) {
            score = makeCloser21(score);
        }

        if (score > 21) {
            participantStatus = ParticipantScore.OVER21;
        }
        if (score == 21) {
            participantStatus = ParticipantScore.SAME21;
        }
        return participantStatus;
    }

    private int makeCloser21(int numberSum) {
        if (numberSum + 10 > 21) {
            return numberSum;
        }
        return Math.max(numberSum, numberSum + 10);
    }

    public String getResultMessage() {
        return getCardsMessage() + String.format(" - 결과 : %d점", score);
    }

    public void setResult() {
//        Map<ParticipantResult, Function<Integer, Integer>> betMoneyCalculate = new HashMap<>();
//
//        betMoneyCalculate.put(ParticipantResult.BLACKJACKWIN, money -> (int) Math.round(money * 2.5));
//        betMoneyCalculate.put(ParticipantResult.WIN, money -> money * 2);
//        betMoneyCalculate.put(ParticipantResult.DRAW, money -> money);
//        betMoneyCalculate.put(ParticipantResult.LOSE, money -> 0);

        int originMoney =
    }
}
