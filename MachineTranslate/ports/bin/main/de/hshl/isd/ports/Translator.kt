package de.hshl.isd.ports

interface Translator {
    suspend fun translate(input: String, sourceLangCode : String, targetLangCode: String): String
}

