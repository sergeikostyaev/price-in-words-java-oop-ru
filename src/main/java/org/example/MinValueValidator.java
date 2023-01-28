package org.example;

import java.math.BigDecimal;

public class MinValueValidator implements Validator<BigDecimal>{

    private BigDecimal minValue;
    public MinValueValidator(BigDecimal minValue) {
        this.minValue = minValue;
    }

    @Override
    public boolean validate(BigDecimal value) {
        return value.compareTo(minValue) >= 0;
    }

    @Override
    public String errorMessage() {
        return "Number is less that 0.1";
    }
}
