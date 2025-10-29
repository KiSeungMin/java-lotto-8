package lotto.lotto;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
