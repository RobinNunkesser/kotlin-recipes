package de.hshl.isd.machinetranslate.infra

import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import de.hshl.isd.ports.Translator
import kotlinx.coroutines.tasks.await

class MLKitTranslator : Translator {

    override suspend fun translate(
        input: String,
        sourceLangCode: String,
        targetLangCode: String
    ): String {
        val options =
            TranslatorOptions.Builder()
                .setSourceLanguage(sourceLangCode)
                .setTargetLanguage(targetLangCode)
                .build()
        val translator = Translation.getClient(options)
        var conditions = DownloadConditions.Builder()
        .requireWifi()
        .build()
        translator.downloadModelIfNeeded(conditions).await()
        val translation = translator.translate(input).await()
    translator.close()
    return translation
    }

}