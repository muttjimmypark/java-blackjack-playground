package blackjack.human;

import blackjack.card.CardSupplier;

public class Dealer extends Participant {
    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(int money) {
        super(DEALER_NAME, money);
    }

    public void moreCardAutoPlay() {
        //OutputView 생기면 sout 두줄 치환

        if (getScore() <= 16) {
//            System.out.println("딜러의 점수가 16 이하이므로, 카드를 한장 더 받았습니다.");
            this.addCard(CardSupplier.getCard());

            return;
        }

        System.out.println("딜러의 점수가 16 초과이므로, 카드를 더 받지 않았습니다.");
        //outputview.dealerAutoPlayMessage(getScore());
    }
}
