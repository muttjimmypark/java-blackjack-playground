package blackjack.view;

import blackjack.card.CardSupplier;
import blackjack.human.Dealer;
import blackjack.human.Participant;
import blackjack.human.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static List<Participant> getParticipants() {
        List<Participant> result = getParticipantsNames().stream()
                .map(InputView::getParticipantMoney)
                .collect(Collectors.toList());

        result.add(new Dealer());

        return result;
    }

    private static List<String> getParticipantsNames() {
        System.out.print("게임에 참여할 사람의 이름을 입력하세요. (쉼표를 기준으로 분리) : ");

        return Arrays.asList(
                new Scanner(System.in).nextLine()
                        .replaceAll(" ", "")
                        .split(","));
    }

    private static Participant getParticipantMoney(String name) {
        System.out.print(name + "의 배팅 금액은? (숫자로 입력) : ");
        return new Player(name, new Scanner(System.in).nextInt());
    }


    /**
     *
     */
    public static Participant askMoreCard(Participant participant) {
        if (participant instanceof Dealer) {
            autoPlayForDealer((Dealer) participant);

            return participant;
        }

        String yn = "";

        while (participant.getLife() && participant.getWantMoreCard()) {
            System.out.print(participant.getName() + "은/는 카드를 한장 더 받겠습니까? (y/n) : ");
            yn = new Scanner(System.in).next().toLowerCase();

            if (yn.equals("y") || yn.equals("n")) {
                break;
            }

            System.out.println("알파벳 y 또는 n 으로 입력하세요.");
        }

        if (yn.equals("y")) {
            participant.addCard(CardSupplier.getCard());
            OutputView.participantStatus(participant);
        }

        if (yn.equals("n")) {
            participant.noMoreWantCard();
        }

        return participant;
    }


    private static void autoPlayForDealer(Dealer dealer) {
        OutputView.dealerAutoPlayMessage(dealer.getScore());

        if (dealer.getScore() <= 16) {
            dealer.addCard(CardSupplier.getCard());
        }
        else {
            dealer.noMoreWantCard();
        }
    }
}
