package org.example;

import org.example.fakes.BigDecimalReaderSpy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.math.BigDecimal;
import java.util.stream.Stream;


public class PriceToWordsFormatterTest {


    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(121256.7), "[сто, двадцать, одна, тысяча, двести, пятьдесят, шесть, рублей, семьдесят, копеек]"),
                Arguments.of(BigDecimal.valueOf(99999999999.09), "[девяносто, девять, миллиардов, девятьсот, девяносто, девять, миллонов, девятьсот, девяносто, девять, тысяч, девятьсот, девяносто, девять, рублей, девять, копеек]"),
                Arguments.of(BigDecimal.valueOf(31298057.90), "[тридцать, один, миллон, двести, девяносто, восемь, тысяч, пятьдесят, семь, рублей, девяносто, копеек]")
        );
    }




    @ParameterizedTest
    @MethodSource("provideArguments")
    public void priceToWordsFormatFMTestParametrized(BigDecimal input, String expected) {
        InputService inputService = new BigDecimalReaderSpy(input);
        Currency currency = new Currency("рубль", "рубля", "рублей","копейка", "копеек", "копейки", false, true);
        PriceToWordsFormatter priceToWordsFormatter = new PriceToWordsFormatter(inputService,currency);
        Assertions.assertEquals(priceToWordsFormatter.makePriceToWordsFormat().toString(), expected);
    }
}