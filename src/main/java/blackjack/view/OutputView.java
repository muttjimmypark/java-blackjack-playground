package blackjack.view;

import blackjack.human.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

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
