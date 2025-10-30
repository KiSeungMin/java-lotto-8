package lotto.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoStatistics {

    private final LottoUserInfo lottoUserInfo;
    private final LottoWinningInfo lottoWinningInfo;
    private final LottoRewardInfo lottoRewardInfo;

    public LottoStatistics(LottoUserInfo lottoUserInfo, LottoWinningInfo lottoWinningInfo) {
        this.lottoUserInfo = lottoUserInfo;
        this.lottoWinningInfo = lottoWinningInfo;
        this.lottoRewardInfo = new LottoRewardInfo();
    }

    public void printLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(lottoUserInfo.getLottoCount() + "개를 구매했습니다.");

        lottoRewardInfo.printUserReward();
        printYield();
    }

    public void calculateAllTickets() {
        List<Integer> winningNumbers = lottoWinningInfo.getWinningNumbers();
        Integer bonusNumber = lottoWinningInfo.getBonusNumber();

        for (Lotto lotto : lottoUserInfo.getLottoTickets()) {
            Integer rank = calculateRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            lottoRewardInfo.addRankCount(rank);
        }
    }

    public Integer calculateRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        Integer matchingCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchingCount++;
            }
        }

        Boolean matchingBonusNumber = false;
        if (matchingCount == 5) {
            matchingBonusNumber = lottoNumbers.contains(bonusNumber);
        }
        return Reward.valueOf(matchingCount, matchingBonusNumber).getIndex();
    }

    public void printYield() {
        System.out.println("총 수익률은 " + getYield() + "%입니다.");
    }

    public BigDecimal getYield() {
        BigDecimal reward = getReward();
        reward = reward.multiply(BigDecimal.valueOf(100));
        BigDecimal yield = reward.divide(BigDecimal.valueOf(lottoUserInfo.getMoney()), 1, RoundingMode.HALF_UP);

        return yield;
    }

    public BigDecimal getReward() {
        return lottoRewardInfo.getTotalReward();
    }
}
