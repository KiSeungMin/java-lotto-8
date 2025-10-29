package lotto;

import java.util.List;

public class LottoManager {
    private Integer lottoCount;
    private List<Lotto> lottos;
    private final InputParser inputParser;

    public LottoManager() {
        this.lottos = lottos;
        this.inputParser = new InputParser();
    }

    public void playGame() {
        getLottoCount();
    }

    public void getLottoCount() {
        Integer money = inputParser.getMoney();
        this.lottoCount = money / 1000;
    }
}
