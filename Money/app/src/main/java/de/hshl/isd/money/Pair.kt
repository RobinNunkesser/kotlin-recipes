package de.hshl.isd.money

import java.util.*

internal class Pair(private val from: String, private val to: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val pair = other as Pair
        return from == pair.from &&
                to == pair.to
    }

    override fun hashCode(): Int {
        return Objects.hash(from, to)
    }

}