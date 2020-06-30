package com.pashaCompany;

import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String name, BigDecimal balance) {
        super(name, balance);
    }

    public DebitCard(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", zero=" + zero +
                '}';
    }


}
