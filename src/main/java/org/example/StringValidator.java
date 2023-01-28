package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StringValidator implements Validator<String>{

    private ArrayList<String> relevantValues;

    public StringValidator(ArrayList<String> relevantValues) {
        this.relevantValues = relevantValues.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean validate(String value) {
        return relevantValues.contains(value);
    }

    @Override
    public String errorMessage() {
        return "Wrong string input";
    }
}
