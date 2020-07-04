package com.pasha;

import exceptions.NotPositiveValueException;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditCard extends Card {

    BigDecimal zero = BigDecimal.valueOf(0);

    public CreditCard(String name, BigDecimal balance) {
        super(name, balance);
    }

    public CreditCard(String name) {
        super(name);
    }

    /*@Override
    public BigDecimal refill(BigDecimal money) throws NotPositiveValueException {
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
        this.balance = this.balance.add(money);
        return this.balance;
    }*/

    @Override
    public BigDecimal withdrawal(BigDecimal money) throws NotPositiveValueException {
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
            this.balance = this.balance.subtract(money);
            return this.balance;
    }

    @Override
    public BigDecimal withdrawalOtherCurrency(BigDecimal money) throws NotPositiveValueException {
        BigDecimal course = BigDecimal.valueOf(2.41);
        if (money.compareTo(zero) == -1){
            throw new NotPositiveValueException("Err");
        }
        this.balance = this.balance.subtract(money.multiply(course));
        return this.balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(zero, that.zero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zero);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "zero=" + zero +
                '}';
    }
}
