package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

class InputTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 정상_금액_입력() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
        });
    }

    @Test
    void 예외_1000원_단위가_아닌_금액_입력 () {
        assertSimpleTest(() -> {
            runException("8500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_1000원_미만_금액_입력 () {
        assertSimpleTest(() -> {
            runException("700");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_음수_금액_입력 () {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_0원_금액_입력 () {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_매우_큰_금액_입력 () {
        assertSimpleTest(() -> {
            runException("20000000000000000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_잘못된_형태_금액_입력 () {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_잘못된_당첨_번호_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1a,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_당첨_번호_개수_부족_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_당첨_번호_개수_초과_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_당첨_번호_잘못된_범위_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "-1,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_당첨_번호_소수_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1.8,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_당첨_번호_중복_숫자_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1,1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_보너스_번호_잘못된_범위_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_보너스_번호_소수_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "3.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_보너스_번호_중복_입력 () {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
