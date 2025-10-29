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
            run("8000");
        });
    }

    @Test
    void 예외_1000원_단위가_아닌_금액_입력 () {
        assertThatThrownBy(() -> run("8500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasNoCause();
    }

    @Test
    void 예외_1000원_미만_금액_입력 () {
        assertThatThrownBy(() -> run("700"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasNoCause();
    }

    @Test
    void 예외_음수_금액_입력 () {
        assertThatThrownBy(() -> run("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasNoCause();
    }

    @Test
    void 예외_0원_금액_입력 () {
        assertThatThrownBy(() -> run("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasNoCause();
    }

    @Test
    void 예외_매우_큰_금액_입력 () {
        assertThatThrownBy(() -> run("20000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasNoCause();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
