package lotto.parser;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.ExceptionMessage.*;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public Integer getMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String input = readLine();
                Integer money = Integer.parseInt(input);
                validateMoney(money);

                return money;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_MONEY_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String input = readLine();
                input = input.replace(" ", "");

                String[] numberTokens = input.split(",");
                List<Integer> winningNumbers = convertToInteger(numberTokens);
                validateWinningNumbers(winningNumbers);

                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_WINNING_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                String input = readLine();
                Integer number = Integer.parseInt(input);

                validateBonusNumber(winningNumbers, number);

                return number;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_BONUS_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> convertToInteger(String[] numberTokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberToken : numberTokens) {
            Integer number = Integer.parseInt(numberToken);
            validateNumber(number);

            numbers.add(number);
        }

        return numbers;
    }

    public void validateMoney(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT);
        }

        if(money / LOTTO_PRICE < 1) {
            throw new IllegalArgumentException(INVALID_MONEY_MINIMUM);
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> distinctWinningNumbers = winningNumbers.stream().distinct().toList();

        if (distinctWinningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT);
        }
        if (winningNumbers.size() != distinctWinningNumbers.size()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DUPLICATE);
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateNumber(bonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE);
        }
    }

    public void validateNumber(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }
}
