package lotto;

import static lotto.constants.LottoRewardConstants.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoStatistics;
import lotto.lotto.LottoUserInfo;
import lotto.lotto.LottoWinningInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {
    @Test
    public void 보상_계산_테스트() {
        List<Lotto> lottoTickets = new ArrayList<>();

        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));     // 1등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));     // 2등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));     // 3등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));     // 4등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));    // 5등
        lottoTickets.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));   // 등수 X
        lottoTickets.add(new Lotto(List.of(1, 3, 4, 5, 6, 2)));     // 1등

        LottoUserInfo lottoUserInfo = new LottoUserInfo(lottoTickets.size(), lottoTickets);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        LottoWinningInfo lottoWinningInfo = new LottoWinningInfo(winningNumbers, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottoUserInfo, lottoWinningInfo);
        lottoStatistics.calculateAllTickets();

        BigDecimal result = new BigDecimal(0);
        result = result.add(BigDecimal.valueOf(FIRST_PRIZE_REWARD * 2));
        result = result.add(BigDecimal.valueOf(SECOND_PRIZE_REWARD));
        result = result.add(BigDecimal.valueOf(THIRD_PRIZE_REWARD));
        result = result.add(BigDecimal.valueOf(FOURTH_PRIZE_REWARD));
        result = result.add(BigDecimal.valueOf(FIFTH_PRIZE_REWARD));

        Assertions.assertThat(result).isEqualTo(lottoStatistics.getReward());
    }
}
