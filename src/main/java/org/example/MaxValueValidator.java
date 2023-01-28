package org.example;

import java.math.BigDecimal;

public class MaxValueValidator implements Validator<BigDecimal>{

    private BigDecimal maxValue;

    public MaxValueValidator(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean validate(BigDecimal value) {
        return value.compareTo(maxValue) < 0;
    }

    @Override
    public String errorMessage() {
        return "Number is more than 9999999999999";
    }

}
