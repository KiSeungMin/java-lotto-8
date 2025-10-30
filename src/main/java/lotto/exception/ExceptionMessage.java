package lotto.exception;

public class ExceptionMessage {
    public static final String INVALID_MONEY_FORMAT = "[ERROR] 숫자 형태의 금액을 입력해주세요.";
    public static final String INVALID_MONEY_UNIT = "[ERROR] 금액은 천 원 단위입니다.";
    public static final String INVALID_MONEY_MINIMUM = "[ERROR] 금액은 천 원 이상입니다.";

    public static final String INVALID_WINNING_NUMBER_FORMAT = "[ERROR] 숫자 형태의 당첨 번호를 입력해주세요.";
    public static final String INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개의 정수로 구성되어야 합니다.";
    public static final String INVALID_WINNING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";

    public static final String INVALID_BONUS_NUMBER_FORMAT = "[ERROR] 숫자 형태의 보너스 번호를 입력해주세요.";
    public static final String INVALID_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.";

    public static final String INVALID_NUMBER_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 정수입니다.";

    public static final String INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
}
