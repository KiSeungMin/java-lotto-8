package lotto.lotto;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import java.util.List;

public class LottoUserInfo {
    private final Integer lottoCount;
    private final List<Lotto> lottoTickets;

    public LottoUserInfo(Integer lottoCount, List<Lotto> lottoTickets) {
        this.lottoCount = lottoCount;
        this.lottoTickets = lottoTickets;
    }

    public Integer getMoney() {
        return this.lottoCount * LOTTO_PRICE;
    }

    public Integer getLottoCount() {
        return this.lottoCount;
    }

    public List<Lotto> getLottoTickets() {
        return this.lottoTickets;
    }

    public void printLottoTickets() {
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.toString());
        }

        System.out.println();
    }
}