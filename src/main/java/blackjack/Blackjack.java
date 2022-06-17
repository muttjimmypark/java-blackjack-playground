package blackjack;

import blackjack.card.CardSupplier;
import blackjack.human.Dealer;
import blackjack.human.Participant;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class Blackjack {

    public List<Participant> initializeGame() {
        List<Participant> result = InputView.getParticipants();

        OutputView.startGameMessage(supplyTwoCards(result));

        return result;
    }

    private List<Participant> supplyTwoCards(List<Participant> participants) {
        List<Participant> result = participants;

        for (int i = 0; i < 1; i++) {
            result.forEach(participant -> participant.addCard(CardSupplier.getCard()));
        }

        for (int i = 0; i < result.size(); i++) {
            Participant isDealer = result.get(i);

            if (isDealer instanceof Dealer) {
                ((Dealer) isDealer).changeHiddenStatusSecondCard();
                result.set(i, isDealer);
            }
        }

        return result;
    }

    /**
     * 21이 발생하는 경우
     * 아무도 카드를 추가로 받지않는 경우
     * 21 오버는 혼자 게임오버고 플레이어가 남아있으면 진행
     * 딜러가 21 오버로 죽는 경우
     */
    public boolean checkGameOver(List<Participant> participants) {
        return checkAppear21(participants)
                || checkNobodyWantMoreCard(participants)
                || checkDealerDead(participants);
    }

    private boolean checkAppear21(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getScore)
                .anyMatch(score -> score == 21);
    }

    private boolean checkNobodyWantMoreCard(List<Participant> participants) {
        return participants.stream()
                .noneMatch(Participant::getWantMoreCard);
    }

    private boolean checkDealerDead(List<Participant> participants) {
        return participants.stream()
                .filter(participant -> participant instanceof Dealer)
                .noneMatch(Participant::getLife);
    }


    /**
     *
     */
    public void finallyCountMoneys(List<Participant> participants) {
    }
}
