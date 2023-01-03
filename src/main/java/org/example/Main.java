package org.example;

public class Main {
    public static void main(String[] args) {

        InputService input = new UserBigDecimalInputReader();
        Currency rubel = new Currency("рубль", "рубля", "рублей","копейка",
                "копеек", "копейки", false, true);
        PriceToWordsFormatter priceToWordsFormatter = new PriceToWordsFormatter(input,rubel);
        priceToWordsFormatter.makePriceToWordsFormat().forEach(c ->  System.out.print(c + " "));
    }
}
