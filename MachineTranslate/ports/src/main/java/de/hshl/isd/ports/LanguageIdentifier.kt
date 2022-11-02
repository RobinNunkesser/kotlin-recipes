package de.hshl.isd.ports

interface LanguageIdentifier {
    suspend fun identifyLanguage(text: String): String
}