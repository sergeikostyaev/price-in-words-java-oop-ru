package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserStringInputReader implements InputService<String, Validator<String>> {
    @Override
    public String read(Validator<String> validators) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String string = "";
        do {
            string = sc.nextLine();
            boolean isSuccessful = true;
                if (!validators.validate(string.toLowerCase())) {
                    System.err.println(validators.errorMessage());
                    isSuccessful = false;
                    break;
                }
                return string;
        } while (true);
        return string;
    }
}

