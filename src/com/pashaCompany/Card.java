package com.pashaCompany;

import Exceptions.NotEnoughMoneyException;
import Exceptions.NotPositiveValueException;

import java.math.BigDecimal;
import java.util.Objects;

public class Card {

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

    public BigDecimal refill(BigDecimal money) throws NotPositiveValueException{
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
        this.balance = this.balance.add(money);
        return this.balance;
    }

    public BigDecimal withdrawal(BigDecimal money)throws NotEnoughMoneyException, NotPositiveValueException {
        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0){
            throw new NotPositiveValueException();
        }
        if (this.balance.compareTo(money) == 1 || this.balance.compareTo(money) == 0){
            this.balance = this.balance.subtract(money);
            return this.balance;
        }else throw new NotEnoughMoneyException();
    }

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
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", zero=" + zero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(name, card.name) &&
                Objects.equals(balance, card.balance) &&
                Objects.equals(zero, card.zero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, zero);
    }


}

