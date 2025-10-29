package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottoTickets;
    private final InputParser inputParser;
    private final LottoGenerator lottoGenerator;

    private Integer lottoCount;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoManager() {
        this.lottoTickets = new ArrayList<>();
        this.inputParser = new InputParser();
        this.lottoGenerator = new LottoGenerator();
    }

    public void playGame() {
        this.lottoCount = getLottoCount();

        this.lottoTickets = getLottoTickets();
        printLottoTickets();

        this.winningNumbers = getWinningNumbers();
        this.bonusNumber = getBonusNumber();
        

    }

    public Integer getLottoCount() {
        Integer money = inputParser.getMoney();
        return money / LOTTO_PRICE;
    }

    public List<Lotto> getLottoTickets() {
        return lottoGenerator.makeLottoTickets(lottoCount);
    }

    public void printLottoTickets() {
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.toString());
        }

        System.out.println();
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
