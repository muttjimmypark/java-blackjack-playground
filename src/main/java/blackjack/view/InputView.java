package blackjack.view;

import blackjack.human.Dealer;
import blackjack.human.Participant;
import blackjack.human.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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

    private static Participant getParticipantMoney(String name) {
        System.out.printf("%s의 배팅 금액은? : ", name);
        return new Player(name, new Scanner(System.in).nextInt());
    }

    private static List<String> getParticipantsNames() {
        System.out.print("게임에 참여할 사람의 이름을 입력하세요. (쉼표를 기준으로 분리) : ");
        String nameInput = new Scanner(System.in).nextLine().replaceAll(" ", "");

        return Arrays.asList(nameInput.split(","));
    }

    public static Participant askMoreCard(Participant participant) {
        do {
            System.out.printf("%s는 카드를 한장 더 받겠습니까? (y/n) : ");
        } while (false);

        String yn = new Scanner(System.in).next().toLowerCase();
    }
}
