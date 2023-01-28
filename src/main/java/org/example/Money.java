package org.example;

import java.math.BigDecimal;

public class Money {

    private BigDecimal money;
    private String code;

    public Money(BigDecimal money, String code) {
        this.money = money;
        this.code = code;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getCode() {
        return code;
    }
}
