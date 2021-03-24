package de.hshl.isd.core.ports

interface SuperComputer {
    suspend fun answer(question: String): String
}