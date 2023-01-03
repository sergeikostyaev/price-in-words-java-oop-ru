package org.example.fakes;

import org.example.InputService;
import java.math.BigDecimal;

public class BigDecimalReaderSpy implements InputService {

    BigDecimal value;

    public BigDecimalReaderSpy(BigDecimal value){
        this.value = value;
    }

    @Override
    public BigDecimal read() {
        return value;
    }
}
