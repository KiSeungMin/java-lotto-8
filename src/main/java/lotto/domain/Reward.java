package lotto.domain;

import static lotto.constants.LottoRewardConstants.*;

public enum Reward {
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

    Reward(int index, int matchCount, boolean bonusMatching, long prize) {
        this.index = index;
        this.matchCount = matchCount;
        this.bonusMatching = bonusMatching;
        this.prize = prize;
    }

    public static Reward valueOf(int matchCount, boolean bonusMatching) {
        for (Reward reward : values()) {
            if (reward.matchCount == matchCount && reward.bonusMatching == bonusMatching) {
                return reward;
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

    public String getFormatStringPrize() {
        return String.format("%,d", this.getPrize()) + "원";
    }

    public String getMessage() {
        String message = "";
        message = message.concat(String.valueOf(this.getMatchCount()));
        message = message.concat("개 일치");

        if (this.equals(Reward.SECOND)) {
            message = message.concat(", 보너스 볼 일치");
        }

        message = message.concat(" (");
        message = message.concat(this.getFormatStringPrize());
        message = message.concat(") - ");

        return message;
    }
}
