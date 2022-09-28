package de.hshl.isd.infrastructure.adapters

import de.hshl.isd.core.ports.SuperComputer
import de.hshl.isd.infrastructure.DeepThought

class SuperComputerAdapter(var adaptee: DeepThought = DeepThought()) :
    SuperComputer {

    override suspend fun answer(question: String): String {
        return adaptee.provideAnswer().toString()
    }
}