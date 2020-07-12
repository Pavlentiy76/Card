package com.pasha.main;

import java.math.BigDecimal;

public class Atm {

    private Card card;

    public Atm(Card card){
        this.card = card;
    }

    public BigDecimal refill(BigDecimal money){
        return card.refill(money);
    }

    public BigDecimal withdrawal(BigDecimal money) {
        return card.withdrawal(money);
    }

    public BigDecimal withdrawalOtherCurrency(BigDecimal money){
        return card.withdrawalOtherCurrency(money);
    }
}
