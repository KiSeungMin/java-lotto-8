package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class InputParser {


    public Integer getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = readLine();
            Integer money = Integer.parseInt(input);
            validateMoney(money);

            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태의 금액을 입력해주세요.");
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String input = readLine();
            input = input.replace(" ", "");

            String[] numberTokens = input.split(",");
            List<Integer> winningNumbers = convertToInteger(numberTokens);

            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태의 당첨 번호를 입력해주세요.");
        }
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String input = readLine();
            Integer number = Integer.parseInt(input);
            validateNumber(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태의 보너스 번호를 입력해주세요.");
        }
    }

    public List<Integer> convertToInteger(String[] numberTokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberToken : numberTokens) {
            Integer number = Integer.parseInt(numberToken);
            validateNumber(number);

            numbers.add(number);
        }

        numbers = transformNumbers(numbers);
        validateNumbers(numbers);

        return numbers;
    }

    public List<Integer> transformNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .toList();
    }

    public void validateMoney(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 원 단위입니다.");
        }

        if(money / LOTTO_PRICE < 1) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 원 이상입니다.");
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 정수여야 합니다.");
        }
    }

    public void validateNumber(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 정수입니다.");
        }
    }
}
