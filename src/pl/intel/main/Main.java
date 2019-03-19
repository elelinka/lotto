package pl.intel.main;
import pl.intel.lotto.Lotto;

public class Main {

    public static void main(String[] args) {

        Lotto lotto = new Lotto();

        lotto.getUserDigit();
        lotto.shuffledDigits();
        lotto.checkedDigits();
    }
}
