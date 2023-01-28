package org.example;

//import org.example.fakes.BigDecimalReaderSpy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;


public class NumbersToWordsFormatterTest {
//    private static Stream<Arguments> provideIrrelevantArguments() {
//        return Stream.of(
//                Arguments.of(BigDecimal.valueOf(1.111), "Wrong format"),
//                Arguments.of(BigDecimal.valueOf(1.1112), "Wrong format"),
//                Arguments.of(BigDecimal.valueOf(1.1311), "Wrong format"),
//                Arguments.of(BigDecimal.valueOf(1.2111), "Wrong format"),
//                Arguments.of(BigDecimal.valueOf(1.1166661), "Wrong format"),
//                Arguments.of(BigDecimal.valueOf(1.11999991), "Wrong format")
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("provideIrrelevantArguments")
//    public void irrelevantFormatTestParametrized(BigDecimal input, String errorString) {
//
//
//        MinValueValidator minValueValidator = new MinValueValidator(BigDecimal.valueOf(0));
//        MaxValueValidator maxValueValidator = new MaxValueValidator(BigDecimal.valueOf(100_000_000_000_00.0));
//        Validator[] validators = {minValueValidator,maxValueValidator};
//        InputService in= new UserBigDecimalInputReader();
//        BigDecimal bigDecimal = in.read(validators);
//        InputService inputService = new BigDecimalReaderSpy(input);
//
//        Currency currency = new Currency("рубль", "рубля", "рублей","копейка", "копеек", "копейки", false, true);
//        String thrownString = null;
//        PriceToWordsFormatter priceToWordsFormatter = new PriceToWordsFormatter(currency);
//        try{
//            priceToWordsFormatter.makePriceToWordsFormat(bigDecimal);
//        }catch (Exception e){
//            thrownString = e.getMessage();
//        }
//
//        Assertions.assertEquals(errorString, thrownString);
//
//    }
}
