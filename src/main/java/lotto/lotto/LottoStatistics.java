package lotto.lotto;

import java.util.List;

public class LottoStatistics {

    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public void setLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
}
