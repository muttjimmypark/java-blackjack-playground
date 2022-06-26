package blackjack;

import blackjack.card.CardSupplier;
import blackjack.human.Dealer;
import blackjack.human.Participant;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class BlackjackService {

    public static List<Participant> initializeGame() {
        List<Participant> result = supplyTwoCards(InputView.getParticipants());

        OutputView.startGameMessage(result);

        return result;
    }

    private static List<Participant> supplyTwoCards(List<Participant> participants) {
        List<Participant> result = participants;

        //초기 카드 2장 배부
        result.forEach(participant -> participant.addCard(CardSupplier.getCard()));
        result.forEach(participant -> participant.addCard(CardSupplier.getCard()));

        //첫 카드공급 후 딜러의 두번째 카드는 히든으로
        Dealer dealer = (Dealer) result.get(result.size() - 1);
        dealer.changeHiddenStatusSecondCard();
        result.set(result.size() - 1, dealer);

        return result;
    }

    /**
     * 본 종료조건이 발동되기 전까지 InputView.askMoreCard가 동작하도록 한다
     *
     * 21이 발생하는 경우
     * 아무도 카드를 추가로 받지않는 경우
     * 21초과는 혼자 게임오버고 플레이어가 남아있으면 진행
     * 딜러가 21 오버로 죽는 경우
     */
    public static boolean checkGameOver(List<Participant> participants) {
        return checkAppear21(participants)
                || checkNobodyWantMoreCard(participants)
                || checkDealerDead(participants);
    }

    private static boolean checkAppear21(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getScore)
                .anyMatch(score -> score == 21);
    }

    private static boolean checkNobodyWantMoreCard(List<Participant> participants) {
        return participants.stream()
                .noneMatch(Participant::getWantMoreCard);
    }

    private static boolean checkDealerDead(List<Participant> participants) {
        return !participants.get(participants.size() - 1).getLife();
    }


    /**
     * 종료되면
     * 1. 스코어는 addCar() 할때마다 수시로 계산하므로 OutputView.participantScoreResult(p)
     * 2. 본 메서드에서 게임 후 수익 계산
     * 3. OutputView.participantsMoneyResult(p)로 최종 수익 출력
     */
    public static void finallyCountMoneys(List<Participant> participants) {
    }
}
