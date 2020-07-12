package com.pasha.tests;

import com.pasha.exceptions.NotPositiveValueException;
import com.pasha.main.CreditCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CreditCardTest {

    CreditCard creditCard;

    @Before
    public void setUp() throws Exception {
        creditCard = new CreditCard("cardTest", BigDecimal.valueOf(5));
    }

    @After
    public void tearDown() throws Exception {
        creditCard = null;
    }

    @Test
    public void refill() {
        BigDecimal actual = creditCard.refill(BigDecimal.valueOf(5));
        BigDecimal expected = BigDecimal.valueOf(10);
        assertEquals(actual, expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void refillNotPositive() {
        BigDecimal actual = creditCard.refill(BigDecimal.valueOf(-4));
        BigDecimal expected = BigDecimal.valueOf(5);
        assertEquals(actual,expected);
    }

    @Test
    public void withdrawal() {
        BigDecimal actual = creditCard.withdrawal(BigDecimal.valueOf(7));
        BigDecimal expected = BigDecimal.valueOf(-2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void withdrawalNotPositive() {
        BigDecimal actual = creditCard.withdrawal(BigDecimal.valueOf(-3));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test
    public void withdrawalOtherCurrency() {
        BigDecimal actual = creditCard.withdrawalOtherCurrency(BigDecimal.valueOf(3));
        BigDecimal expected = BigDecimal.valueOf(-2.23);
        assertEquals(actual,expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void withdrawalOtherCurrencyNotPositive() {
        BigDecimal actual = creditCard.withdrawalOtherCurrency(BigDecimal.valueOf(-3));
        BigDecimal expected = BigDecimal.valueOf(-2.23);
        assertEquals(actual,expected);
    }
}