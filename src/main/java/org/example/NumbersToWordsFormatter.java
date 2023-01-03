package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersToWordsFormatter {

    private static final String[] NUMBERS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",
            "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] DEC_2090 = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    public static ArrayList<String> convertNumberToSentence(long number) {

        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> numbers = divideIntoParts(number);
        Collections.reverse(numbers);
        if(number == 0) return new ArrayList<>(Collections.singleton("ноль"));

        for (int i = numbers.size() - 1; i >= 0; i--) {
            convertPartToLetters(result, numbers.get(i));
            switch (i) {
                case 4 -> makeFormat(result, numbers, 4, "триллион", "триллиона", "триллионов");
                case 3 -> makeFormat(result, numbers, 3, "миллиард", "миллиарда", "миллиардов");
                case 2 -> makeFormat(result, numbers, 2, "миллон", "миллона", "миллонов");
                case 1 -> {
                    makeFormat(result, numbers, 1, "тысяча", "тысячи", "тысяч");
                    if (numbers.get(1) % 10 == 1 && result.contains("тысяча")) result.set(result.indexOf("тысяча") - 1, "одна");
                    if (numbers.get(1) % 10 == 2 && result.contains("тысячи")) result.set(result.indexOf("тысячи") - 1, "две");
                }
            }
        }

        return result;
    }

    private static void makeFormat(ArrayList<String> al, ArrayList<Integer> numbers, int pos, String n, String na, String nov) {
        if (sumPart(numbers.get(pos)) != 0) {
            if (numbers.get(pos) % 100 != 11 && numbers.get(pos) % 10 == 1) {
                al.add(n);
            } else if (numbers.get(pos) % 10 >= 2 && numbers.get(pos) % 10 <= 4 && numbers.get(pos) % 100
                    != 13 && numbers.get(pos) % 100 != 12 && numbers.get(pos) % 100 != 14) {
                al.add(na);
            } else {
                al.add(nov);
            }
        }
    }
    private static void convertPartToLetters(ArrayList<String> al, int a) {

        int[] nums = {a / 100, (a / 10) % 10, a % 10};
        if (nums[0] != 0) al.add(HUNDREDS[nums[0]]);
        if (nums[1] != 0 && nums[1] >= 2) {
            al.add(DEC_2090[nums[1]]);
            al.add(NUMBERS[nums[2]]);
        } else al.add(NUMBERS[a % 100]);
        al.removeIf(s -> s.equals(""));
    }
    private static ArrayList<Integer> divideIntoParts(long a) {
        ArrayList<Integer> res = new ArrayList<>();
        do {
            res.add(0, (int) (a % 1000));
            a = a / 1000;
        } while (a != 0);
        return res;
    }
    private static int sumPart(int a) {return (a / 100) + ((a / 10) % 10) + (a % 10);}
}
