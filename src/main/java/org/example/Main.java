package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        Validator<BigDecimal> minValueValidator = new MinValueValidator(BigDecimal.valueOf(0));
        Validator<BigDecimal> maxValueValidator = new MaxValueValidator(BigDecimal.valueOf(100_000_000_000_00.0));
        ArrayList<Validator<BigDecimal>> BigDecimalValidators = new ArrayList<>(List.of(minValueValidator,maxValueValidator));
        Validator<String> stringValuesValidator = new StringValidator(new ArrayList<>(List.of("rub","eur","usd")));

        InputService<BigDecimal, ArrayList<Validator<BigDecimal>>> userBigDecimalInputReader = new UserBigDecimalInputReader();
        InputService<String, Validator<String>> userStringInputReader = new UserStringInputReader();


        do {

            Money money = new Money(userBigDecimalInputReader.read(BigDecimalValidators), userStringInputReader.read(stringValuesValidator));

            PriceToWordsFormatter priceToWordsFormatter = new PriceToWordsFormatter(Currency.getCurrency(money.getCode()));
            priceToWordsFormatter.makePriceToWordsFormat(money.getMoney()).forEach(c -> System.out.print(c + " "));
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }while (true);
    }
}
