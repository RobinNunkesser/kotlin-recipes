package de.hshl.isd.machinetranslate

import de.hshl.isd.machinetranslate.infra.MLKitLanguageIdentifier
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MLKitLanguageIdentifierTest {
    @Test
    fun identifyLanguage_isCorrect() {
        val languageIdentifier = MLKitLanguageIdentifier()
        val language = runBlocking { languageIdentifier.identifyLanguage("Hello world") }
            assertEquals("en", language)
            //assertEquals("en", runBlocking { languageIdentifier.identifyLanguage("Hello world") })
    }
}