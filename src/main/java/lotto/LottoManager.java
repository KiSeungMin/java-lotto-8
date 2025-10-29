package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;
    private final InputParser inputParser;

    private Integer lottoCount;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;



    public LottoManager() {
        this.lottos = new ArrayList<>();
        this.inputParser = new InputParser();
    }

    public void playGame() {
        this.lottoCount = getLottoCount();

        this.winningNumbers = getWinningNumbers();
        this.bonusNumber = getBonusNumber();
    }

    public Integer getLottoCount() {
        Integer money = inputParser.getMoney();
        return money / 1000;
    }

    public List<Integer> getWinningNumbers() {
        return inputParser.getWinningNumbers();
    }

    public Integer getBonusNumber() {
        Integer bonusNumber = inputParser.getBonusNumber();
        validateBonusNumber(bonusNumber);

        return bonusNumber;
    }

    public void validateBonusNumber(Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.");
        }
    }
}
