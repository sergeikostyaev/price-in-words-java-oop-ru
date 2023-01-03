package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.example.NumbersToWordsFormatter.convertNumberToSentence;

public class PriceToWordsFormatter {
    private final InputService reader;
    private final Currency currency;

    public PriceToWordsFormatter(InputService reader, Currency currency) {
        this.reader = reader;
        this.currency = currency;
    }

    public ArrayList<String> makePriceToWordsFormat(){
        BigDecimal bigDecimal = reader.read();
        ArrayList<String> result = convertNumberToSentence(getIntegerValue(bigDecimal));

        switch (result.get(result.size()-1)){
            case "один" -> {
                if(currency.isRubelFem()) result.set(result.size() - 1, "одна");
                result.add(currency.getRubel());
            }
            case "два" -> {
                if(currency.isRubelFem()) result.set(result.size() - 1, "две");
                result.add(currency.getRublya());
            }
            case "три", "четыре" -> result.add(currency.getRublya());
            default -> result.add(currency.getRubley());
        }

        result.addAll(convertNumberToSentence(makeFactorialFormat(getFactorialValue(bigDecimal))));

        switch (result.get(result.size()-1)){
            case "один" -> {
                if(currency.isKopeykaFem()) result.set(result.size() - 1, "одна");
                result.add(currency.getKopeyka());
            }
            case "два" -> {
                if(currency.isKopeykaFem()) result.set(result.size() - 1, "две");
                result.add(currency.getKopeyki());
            }
            case "три", "четыре" -> result.add(currency.getKopeyki());
            default -> result.add(currency.getKopeek());
        }
        return result;
    }

    private static long getIntegerValue(BigDecimal value){
        return value.longValue();
    }

    private static String getFactorialValue(BigDecimal value){
        String temp = value.subtract(new BigDecimal(getIntegerValue(value))).toPlainString();
        return temp.substring(temp.indexOf('.')+1);
    }

    private static long makeFactorialFormat(String factorial){
        if(factorial.length() > 2) throw new IllegalArgumentException("Wrong format");
        if(Long.parseLong(factorial) < 0) throw new IllegalArgumentException("Wrong format");
        if(Long.parseLong(factorial) < 10 && factorial.length() == 1) {
            return Long.parseLong(factorial)*10;
        }
        return Long.parseLong(factorial);
    }
}
