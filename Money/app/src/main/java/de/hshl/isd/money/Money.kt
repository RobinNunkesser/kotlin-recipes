package de.hshl.isd.money

class Money(var amount: Int, val currency: String) {

    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    operator fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    operator fun plus(addend: Money): Money? {
        return Money(amount + addend.amount, currency).takeUnless { currency != addend.currency }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false
        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = amount
        result = 31 * result + currency.hashCode()
        return result
    }

    fun reduce(bank: Bank, to: String): Money? {
        val rate = bank.rate(currency, to)
        return rate?.let { Money(amount / rate, to) }
    }

}