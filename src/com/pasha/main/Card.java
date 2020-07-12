package com.pasha.main;

import com.pasha.exceptions.NotEnoughMoneyException;
import com.pasha.exceptions.NotPositiveValueException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Card {

    protected String name;
    protected BigDecimal balance;

    BigDecimal zero = BigDecimal.valueOf(0);

    public Card(String name, BigDecimal balance){
        this.name = name;
        this.balance = balance;
    }

    public Card(String name){
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal refill(BigDecimal money) throws NotPositiveValueException {
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
        balance = balance.add(money);
        return balance;
    }

    public abstract BigDecimal withdrawal(BigDecimal money)throws NotEnoughMoneyException, NotPositiveValueException;

    public abstract BigDecimal withdrawalOtherCurrency(BigDecimal money)throws NotEnoughMoneyException,
            NotPositiveValueException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(name, card.name) &&
                Objects.equals(balance, card.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

}

