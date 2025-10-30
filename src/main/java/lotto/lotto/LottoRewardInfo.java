package lotto.lotto;

import static lotto.constants.LottoConstants.REWARD_LIMIT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoRewardInfo {
    private List<Integer> rankCounts;

    public LottoRewardInfo() {
        this.rankCounts = new ArrayList();
        for (int i = 0; i <= REWARD_LIMIT; i++) {
            rankCounts.add(0);
        }
    }

    public void addRankCount(Integer rank) {
        Integer count = rankCounts.get(rank);
        rankCounts.set(rank, count + 1);
    }

    public BigDecimal getTotalReward() {
        BigDecimal totalReward = new BigDecimal(0);
        for (int i = 1; i <= REWARD_LIMIT; i++) {
            totalReward = totalReward.add(BigDecimal.valueOf(rankCounts.get(i) * Reward.values()[i].getPrize()));
        }
        return totalReward;
    }

    public void printUserReward() {
        for (int rank = REWARD_LIMIT; rank >= 1; rank--) {
            System.out.println(getRankRewardMessage(rank));
        }
    }

    public String getRankRewardMessage(Integer rank) {
        Reward rewardEnum = Reward.values()[rank];

        String rewardMessage = rewardEnum.getMessage();

        rewardMessage = rewardMessage.concat(String.valueOf(rankCounts.get(rank)));
        rewardMessage = rewardMessage.concat("개");

        return rewardMessage;
    }
}
