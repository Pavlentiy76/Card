package Tests;

import Exceptions.NotEnoughMoneyException;
import Exceptions.NotPositiveValueException;
import com.pashaCompany.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CardTest {

    Card card;

    @Before
    public void setUp() throws Exception {
        card = new Card("cardTest",BigDecimal.valueOf(5));
    }

    @After
    public void tearDown() throws Exception {
        card = null;
    }

    @Test
    public void refill() {
        BigDecimal actual = card.refill(BigDecimal.valueOf(5));
        BigDecimal expected = BigDecimal.valueOf(10);
        assertEquals(actual, expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void refillNotPositive() {
        BigDecimal actual = card.refill(BigDecimal.valueOf(-4));
        BigDecimal expected = BigDecimal.valueOf(5);
        assertEquals(actual,expected);
    }

    @Test
    public void withdrawal() {
        BigDecimal actual = card.withdrawal(BigDecimal.valueOf(3));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void withdrawalNotPositive() {
        BigDecimal actual = card.withdrawal(BigDecimal.valueOf(-3));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawalNotEnoughMoney() {
        BigDecimal actual = card.withdrawal(BigDecimal.valueOf(6));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test
    public void withdrawalOtherCurrency() {
        BigDecimal actual = card.withdrawalOtherCurrency(BigDecimal.valueOf(1));
        BigDecimal expected = BigDecimal.valueOf(2.59);
        assertEquals(actual,expected);
    }

    @Test(expected = NotPositiveValueException.class)
    public void withdrawalOtherCurrencyNotPositive() {
        BigDecimal actual = card.withdrawalOtherCurrency(BigDecimal.valueOf(-1));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawalOtherCurrencyNotEnoughMoney() {
        BigDecimal actual = card.withdrawalOtherCurrency(BigDecimal.valueOf(10));
        BigDecimal expected = BigDecimal.valueOf(2);
        assertEquals(actual,expected);
    }
}