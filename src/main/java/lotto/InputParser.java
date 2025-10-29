package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParser {
    public Integer getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();

        try {
            Integer money = Integer.parseInt(input);
            validateMoney(money);

            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태의 금액을 입력해주세요.");
        }
    }

    public void validateMoney(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 원 단위입니다.");
        }

        if(money / 1000 < 1) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 원 이상입니다.");
        }
    }
}
