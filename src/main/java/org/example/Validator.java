package org.example;

import java.math.BigDecimal;

public interface Validator<T> {
    boolean validate(T value);
    String errorMessage();
}
