package com.pasha.tests;

import com.pasha.exceptions.NotEnoughMoneyException;
import com.pasha.exceptions.NotPositiveValueException;
import com.pasha.main.DebitCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DebitCardTest {

    DebitCard debitCard;

    @Before
    public void setUp() throws Exception {
        debitCard = new DebitCard("debitCard", BigDecimal.valueOf(5));
    }

    @After
    public void tearDown() throws Exception {
        debitCard = null;
    }

    @Test
    public void refill() {
        BigDecimal actual = debitCard.refill(BigDecimal.valueOf(5));
        BigDecimal expected = BigDecimal.valueOf(10);
        assertEquals(actual, expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void refillNotPositive() {
        BigDecimal actual = debitCard.refill(BigDecimal.valueOf(-4));
        BigDecimal expected = BigDecimal.valueOf(5);
        assertEquals(actual,expected);
    }

    @Test
    public void withdrawal() {
        BigDecimal actual = debitCard.withdrawal(BigDecimal.valueOf(3));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void withdrawalNotPositive() {
        BigDecimal actual = debitCard.withdrawal(BigDecimal.valueOf(-3));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawalNotEnoughMoney() {
        BigDecimal actual = debitCard.withdrawal(BigDecimal.valueOf(6));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test
    public void withdrawalOtherCurrency() {
        BigDecimal actual = debitCard.withdrawalOtherCurrency(BigDecimal.valueOf(1));
        BigDecimal expected = BigDecimal.valueOf(2.59);
        assertEquals(actual,expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void withdrawalOtherCurrencyNotPositive() {
        BigDecimal actual = debitCard.withdrawalOtherCurrency(BigDecimal.valueOf(-1));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawalOtherCurrencyNotEnoughMoney() {
        BigDecimal actual = debitCard.withdrawalOtherCurrency(BigDecimal.valueOf(10));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }
}