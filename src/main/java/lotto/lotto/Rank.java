package lotto.lotto;

import static lotto.constants.LottoRewardConstants.*;

public enum Rank {
    ZERO(0, 0, false, 0),
    FIRST(1, 6, false, FIRST_PRIZE_REWARD),
    SECOND(2, 5, true, SECOND_PRIZE_REWARD),
    THIRD(3, 5, false, THIRD_PRIZE_REWARD),
    FOURTH(4, 4, false, FOURTH_PRIZE_REWARD),
    FIFTH(5, 3, false, FIFTH_PRIZE_REWARD);

    private final int index;
    private final int matchCount;
    private final boolean bonusMatching;
    private final long prize;

    Rank(int index, int matchCount, boolean bonusMatching, long prize) {
        this.index = index;
        this.matchCount = matchCount;
        this.bonusMatching = bonusMatching;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatching) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatching == bonusMatching) {
                return rank;
            }
        }
        return ZERO;
    }

    public int getIndex() {
        return index;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}
