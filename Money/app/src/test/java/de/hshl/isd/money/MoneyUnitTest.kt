package de.hshl.isd.money

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class MoneyUnitTest {
    @Test
    fun testDollarMultiplication() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five * 2)
        assertEquals(Money.dollar(15), five * 3)
    }

    @Test
    fun testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5))
        assertNotEquals(Money.dollar(5), Money.dollar(6))
        assertNotEquals(Money.franc(5), Money.dollar(5))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency)
        assertEquals("CHF", Money.franc(1).currency)
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result = bank.reduce(Money.dollar(1), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum = five + five
        val bank = Bank()
        val reduced = bank.reduce(sum!!, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

}