package de.hshl.isd.infrastructure

import kotlinx.coroutines.delay

class DeepThought {
    suspend fun provideAnswer(): Int {
        delay(1000L)
        return 42
    }
}