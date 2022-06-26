package blackjack.view;

import blackjack.human.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void dealerAutoPlayMessage(int dealerScore) {
        if (dealerScore > 16) {
            System.out.println("딜러의 점수가 16 초과이므로, 카드를 더 받지 않았습니다.");
            return;
        }

        System.out.println("딜러의 점수가 16 이하이므로, 카드를 한장 더 받았습니다.");
    }

    public static void startGameMessage(List<Participant> participants) {
        System.out.println(participants.stream()
                        .map(Participant::getName)
                        .collect(Collectors.toList())
                        + "에게 2장씩 카드를 나눠줬습니다.");
    }

    public static void participantStatus(Participant participant) {
        System.out.println(participant.getName() + "의 카드 : " + participant.getCardsString());
    }

    public static void participantScoreResult(Participant participant) {
        participantStatus(participant);
        System.out.println("->  점수 결과 : " + participant.getScore());
    }

    public static void participantsMoneyResult(List<Participant> participants) {
        System.out.println("## 최종 수익");
        participants.forEach(participant -> participantMoneyResult(participant));
    }

    private static void participantMoneyResult(Participant participant) {
        System.out.println(participant.getName() + " : " + participant.getFirstMoney() + " -> " + participant.getLastMoney());
    }
}
