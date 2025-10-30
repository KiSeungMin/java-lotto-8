package lotto;

import lotto.service.LottoManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = new LottoManager();
        lottoManager.playGame();
    }
}
