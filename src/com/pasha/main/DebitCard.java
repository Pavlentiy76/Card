package com.pasha.main;

import com.pasha.exceptions.NotEnoughMoneyException;
import com.pasha.exceptions.NotPositiveValueException;

import java.math.BigDecimal;
import java.util.Objects;

public class DebitCard extends Card {

    BigDecimal zero = BigDecimal.valueOf(0);

    public DebitCard(String name, BigDecimal balance) {
        super(name, balance);
    }

    public DebitCard(String name) {
        super(name);
    }

    @Override
    public BigDecimal withdrawal(BigDecimal money)throws NotEnoughMoneyException, NotPositiveValueException {
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
        if (this.balance.compareTo(money) == 1 || this.balance.compareTo(money) == 0){
            this.balance = this.balance.subtract(money);
            return this.balance;
        }else throw new NotEnoughMoneyException();
    }

    @Override
    public BigDecimal withdrawalOtherCurrency(BigDecimal money)throws NotEnoughMoneyException, NotPositiveValueException {
        BigDecimal course = BigDecimal.valueOf(2.41);
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
        if (this.balance.compareTo(money.multiply(course)) == 1 || this.balance.compareTo(money.multiply(course)) == 0){
            this.balance = this.balance.subtract(money.multiply(course));
            return this.balance;
        }else throw new NotEnoughMoneyException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebitCard debitCard = (DebitCard) o;
        return Objects.equals(zero, debitCard.zero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zero);
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "zero=" + zero +
                '}';
    }
}
