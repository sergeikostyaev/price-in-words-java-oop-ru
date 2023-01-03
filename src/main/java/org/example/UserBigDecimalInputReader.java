package org.example;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class UserBigDecimalInputReader implements InputService {

    @Override
    public BigDecimal read() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        BigDecimal res = BigDecimal.valueOf(0);
        do {
            BigDecimal temp = BigDecimal.valueOf(sc.nextDouble());
            if (temp.compareTo(BigDecimal.valueOf(0)) >= 0 && temp.compareTo(BigDecimal.valueOf(100_000_000_000_00.0)) < 0) {
                res = temp;
                break;
            } else {
                System.out.println("Введите число от 1 до 9999999999999");
            }
        } while (true);

        return res;
    }
}
