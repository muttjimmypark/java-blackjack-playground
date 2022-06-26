package blackjack.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    public static final int BLACKJACK = 21;
    List<Card> cards;
    int score;

    public Cards() {
        cards = new ArrayList<>();
        score = 0;
    }

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    public void changeHiddenStatusSecondCard() {
        /**
         * Cards를 생성하면서 소유자의 instanceOf를 확인해서
         * Dealer의 경우 addCard에서 자동으로 두번째 카드를 히든으로 만들어보려 했지만
         * 어짜피 게임종료 시점에서 히든카드도 오픈을 해야하므로
         * 절차적으로 필요한 시기에 호출을 하도록 개별 메서드로 정리
         */
        if (cards.size() >= 2) {
            cards.set(1, cards.get(1).changeHiddenStatus());
        }
    }

    public int getScore() {
        calculateScore();
        return score;
    }

    private void calculateScore() {
        score = cards.stream()
                .mapToInt(Card::getNumberForCalculate)
                .sum();

        if (cards.stream()
                .anyMatch(card -> card.getNumberForCalculate() == 1)) {
            compareOneToEleven();
        }
    }

    private void compareOneToEleven() {
        //가진 패에 1이 발견돼서 (21이하 && 21에 제일 가까운 경우)를 찾아야할 때 호출하는 메서드
        //보유카드중에 1이 여러개여도 두개이상 11로 치환해봐야 21초과임
        //따라서 보유카드중에 1이 한개이상 있을때, 그중 하나만을 (1 -> 11로 볼경우) 21초과 안하면 그대로 반영

        int ifEleven = score + 10;
        if (ifEleven <= BLACKJACK) {
            score = ifEleven;
        }
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
