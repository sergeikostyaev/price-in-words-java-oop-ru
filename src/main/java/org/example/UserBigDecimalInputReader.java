package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserBigDecimalInputReader implements InputService<BigDecimal, ArrayList<Validator<BigDecimal>>> {

    @Override
    public BigDecimal read(ArrayList<Validator<BigDecimal>> validators) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        do {
            String string = sc.nextLine();
            BigDecimal temp = BigDecimal.valueOf(Double.parseDouble(string));
            boolean isSuccessful = true;
            for(Validator<BigDecimal> v: validators){
                if(!v.validate(temp)){
                    System.err.println(v.errorMessage());
                    isSuccessful = false;
                    break;
                }
            }
            if(isSuccessful) {
                return temp;
            }
        } while (true);
    }



}

