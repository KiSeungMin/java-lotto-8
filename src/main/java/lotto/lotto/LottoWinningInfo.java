package lotto.lotto;

import static lotto.exception.ExceptionMessage.INVALID_BONUS_NUMBER_DUPLICATE;

import java.util.List;

public class LottoWinningInfo {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoWinningInfo(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void validateBonusNumber(Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE);
        }
    }
}
