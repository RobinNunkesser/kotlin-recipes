package de.hshl.isd.core

import de.hshl.isd.core.ports.GetAnswerCommand
import de.hshl.isd.core.ports.SuperComputer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConcreteGetAnswerCommand(val superComputer: SuperComputer)
    : GetAnswerCommand{
    override suspend fun execute(inDTO: String): String {
        return superComputer.answer(inDTO)
    }

}