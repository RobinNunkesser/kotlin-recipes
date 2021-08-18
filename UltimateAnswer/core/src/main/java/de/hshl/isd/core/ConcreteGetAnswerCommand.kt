package de.hshl.isd.core

import de.hshl.isd.core.ports.GetAnswerCommand
import de.hshl.isd.core.ports.SuperComputer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConcreteGetAnswerCommand(val superComputer: SuperComputer)
    : GetAnswerCommand{
    override fun execute(
        inDTO: String,
        successHandler: (success: String) -> Unit,
        errorHandler: (error: Throwable) -> Unit
    ) {
        GlobalScope.launch {
            val result = runCatching {  superComputer.answer(inDTO) }
            result.onSuccess(successHandler)
            result.onFailure(errorHandler)
        }
    }
}