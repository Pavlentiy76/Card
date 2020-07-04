package com.pasha;

import exceptions.NotEnoughMoneyException;
import exceptions.NotPositiveValueException;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Card c = new CreditCard("ret",BigDecimal.valueOf(65));

        Atm a = new Atm(c);

        a.refill(BigDecimal.valueOf(7));

        System.out.println(c.getBalance());
        try {
            a.withdrawalOtherCurrency(BigDecimal.valueOf(-100));
        }catch (NotEnoughMoneyException ex){
            System.out.println("Not enough money");
        }catch (NotPositiveValueException ex){
            System.out.println("Zero");
        }
        System.out.println(c.getBalance());

    }
}
