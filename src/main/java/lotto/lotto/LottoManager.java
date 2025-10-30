package lotto.lotto;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import java.util.List;
import lotto.parser.InputParser;

public class LottoManager {
    private final InputParser inputParser;
    private final LottoGenerator lottoGenerator;

    public LottoManager() {
        this.inputParser = new InputParser();
        this.lottoGenerator = new LottoGenerator();
    }

    public void playGame() {
        LottoUserInfo lottoUserInfo = makeLottoUserInfo();
        lottoUserInfo.printLottoTickets();

        LottoWinningInfo lottoWinningInfo = makeLottoWinningInfo();

        LottoStatistics lottoStatistics = new LottoStatistics(lottoUserInfo, lottoWinningInfo);
        lottoStatistics.calculateAllTickets();
        lottoStatistics.printLottoResult();
    }

    public LottoUserInfo makeLottoUserInfo() {
        Integer lottoCount = inputParser.getMoney() / LOTTO_PRICE;
        List<Lotto> lottoTickets = lottoGenerator.makeLottoTickets(lottoCount);

        return new LottoUserInfo(lottoCount, lottoTickets);
    }

    public LottoWinningInfo makeLottoWinningInfo() {
        List<Integer> winningNumbers = inputParser.getWinningNumbers();
        Integer bonusNumber = inputParser.getBonusNumber();

        return new LottoWinningInfo(winningNumbers, bonusNumber);
    }
}
