package de.hshl.isd.infrastructure

/*import com.google.mlkit.nl.translate.TranslatorOptions
import de.hshl.isd.ports.Translator

class MLKitTranslator : Translator {

    companion object {
        private const val NUM_TRANSLATORS = 3
    }

    private val translators =
        object : LruCache<TranslatorOptions, Translator>(NUM_TRANSLATORS) {
            override fun create(options: TranslatorOptions): Translator {
                return Translation.getClient(options)
            }
            override fun entryRemoved(
                evicted: Boolean,
                key: TranslatorOptions,
                oldValue: Translator,
                newValue: Translator?,
            ) {
                oldValue.close()
            }
        }
}
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
        translators[options].downloadModelIfNeeded().continueWithTask { task ->
            if (task.isSuccessful) {
                translators[options].translate(text)
            } else {
                Tasks.forException<String>(
                    task.exception
                        ?: Exception(getApplication<Application>().getString(R.string.unknown_error))
                )
            }

    }

}*/