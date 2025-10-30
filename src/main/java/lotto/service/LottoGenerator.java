package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoGenerator {
    public List<Lotto> makeLottoTickets(Integer lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = makeLottoNumbers();

            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    public List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);

        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
        return lottoNumbers;
    }
}
