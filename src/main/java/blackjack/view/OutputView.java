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
        System.out.printf("%s에게 2장씩 카드를 나눠줬습니다.",
                participants.stream()
                        .map(Participant::getName)
                        .collect(Collectors.toList())
                );
    }

    public static void participantStatus(Participant participant) {
        System.out.printf("%s의 카드 : %s", participant.getName(), participant.getCardsString());
    }

    public static void participantScoreResult(Participant participant) {
        participantStatus(participant);
        System.out.printf("->  점수 결과 : %d", participant.getScore());
    }

    public static void participantsMoneyResult(List<Participant> participants) {
        System.out.println("## 최종 수익");
        participants.forEach(participant -> participantMoneyResult(participant));
    }

    private static void participantMoneyResult(Participant participant) {
        System.out.printf("%s : %d", participant.getName(), participant.getMoney());
    }
}
