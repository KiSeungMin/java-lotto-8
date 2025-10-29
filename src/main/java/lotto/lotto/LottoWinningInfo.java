package lotto.lotto;

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
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.");
        }
    }
}
