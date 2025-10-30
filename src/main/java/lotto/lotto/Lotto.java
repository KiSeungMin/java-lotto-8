package lotto.lotto;

import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_DUPLICATE;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
        }

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (Integer num : numbers) {
            result.append(num).append(", ");
        }

        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        result.append("]");

        return result.toString();
    }
}
