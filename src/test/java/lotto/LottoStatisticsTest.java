package lotto;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoRewardConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoStatistics;
import lotto.lotto.LottoUserInfo;
import lotto.lotto.LottoWinningInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest extends NsTest {

    private List<Lotto> lottoTickets = new ArrayList<>();

    private LottoUserInfo lottoUserInfo;
    private LottoWinningInfo lottoWinningInfo;
    private LottoStatistics lottoStatistics;

    @BeforeEach
    public void before() {
        addLottoTickets();
        addLottoUserInfo();
        addLottoWinningInfo();
        addLottoStatistics();
    }

    @AfterEach
    public void after() {
        lottoTickets.clear();
        lottoUserInfo = null;
        lottoWinningInfo = null;
        lottoStatistics = null;
    }

    private void addLottoTickets() {
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));     // 1등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));     // 2등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));     // 3등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));     // 4등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));    // 5등
        lottoTickets.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));   // 등수 X
        lottoTickets.add(new Lotto(List.of(1, 3, 4, 5, 6, 2)));     // 1등
    }

    private void addLottoUserInfo() {
        this.lottoUserInfo = new LottoUserInfo(lottoTickets.size(), lottoTickets);
    }

    private void addLottoWinningInfo() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        this.lottoWinningInfo = new LottoWinningInfo(winningNumbers, bonusNumber);
    }

    private void addLottoStatistics() {
        this.lottoStatistics = new LottoStatistics(lottoUserInfo, lottoWinningInfo);
    }

    @Test
    public void 보상_계산_테스트() {
        lottoStatistics.calculateAllTickets();

        BigDecimal result = new BigDecimal(0);
        result = result.add(BigDecimal.valueOf(FIRST_PRIZE_REWARD * 2));
        result = result.add(BigDecimal.valueOf(SECOND_PRIZE_REWARD));
        result = result.add(BigDecimal.valueOf(THIRD_PRIZE_REWARD));
        result = result.add(BigDecimal.valueOf(FOURTH_PRIZE_REWARD));
        result = result.add(BigDecimal.valueOf(FIFTH_PRIZE_REWARD));

        assertThat(result).isEqualTo(lottoStatistics.getReward());
    }

    @Test
    public void 보상_출력_테스트() {
        lottoStatistics.calculateAllTickets();
        lottoStatistics.printLottoResult();

        assertThat(output()).contains(
                "당첨 통계",
                "---",
                lottoTickets.size() + "개를 구매했습니다.",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 2개"
        );
    }

    @Test
    public void 수익률_출력_테스트() {
        lottoStatistics.calculateAllTickets();
        lottoStatistics.printLottoResult();

        BigDecimal reward = new BigDecimal(0);
        reward = reward.add(BigDecimal.valueOf(FIRST_PRIZE_REWARD * 2));
        reward = reward.add(BigDecimal.valueOf(SECOND_PRIZE_REWARD));
        reward = reward.add(BigDecimal.valueOf(THIRD_PRIZE_REWARD));
        reward = reward.add(BigDecimal.valueOf(FOURTH_PRIZE_REWARD));
        reward = reward.add(BigDecimal.valueOf(FIFTH_PRIZE_REWARD));

        reward = reward.multiply(BigDecimal.valueOf(100));
        BigDecimal yield = reward.divide(BigDecimal.valueOf(lottoTickets.size() * LOTTO_PRICE), 1, RoundingMode.HALF_UP);

        assertThat(output()).contains(
                "총 수익률은 " + yield + "%입니다."
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
