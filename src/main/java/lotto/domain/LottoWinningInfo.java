package lotto.domain;

import java.util.List;

public class LottoWinningInfo {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoWinningInfo(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
