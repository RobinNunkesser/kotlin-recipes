package de.hshl.isd.money

class Bank {
    private val rates: MutableMap<Pair, Int> = mutableMapOf()
    fun reduce(source: Money, to: String): Money? {
        return source.reduce(this, to)
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }

    fun rate(from: String, to: String): Int? {
        return if (from == to) 1 else rates[Pair(from, to)]
    }
}
