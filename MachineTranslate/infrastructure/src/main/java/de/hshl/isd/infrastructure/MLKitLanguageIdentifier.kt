package de.hshl.isd.infrastructure

import com.google.mlkit.nl.languageid.LanguageIdentification
import de.hshl.isd.ports.LanguageIdentifier
import kotlinx.coroutines.tasks.await

class MLKitLanguageIdentifier : LanguageIdentifier {
    override suspend fun identifyLanguage(text: String): String {
        val languageIdentifier = LanguageIdentification.getClient()
        return languageIdentifier.identifyLanguage(text).await()
    }

}