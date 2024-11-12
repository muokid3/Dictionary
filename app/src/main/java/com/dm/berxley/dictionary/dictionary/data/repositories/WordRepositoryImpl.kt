package com.dm.berxley.dictionary.dictionary.data.repositories

import com.dm.berxley.dictionary.core.domain.util.Error
import com.dm.berxley.dictionary.core.domain.util.Result
import com.dm.berxley.dictionary.dictionary.data.local.WordDao
import com.dm.berxley.dictionary.dictionary.data.remote.WordApi
import com.dm.berxley.dictionary.dictionary.domain.models.Word
import com.dm.berxley.dictionary.dictionary.domain.repositories.WordRepository

class WordRepositoryImpl(
    private val wordApi: WordApi,
    private val wordDao: WordDao
): WordRepository {
    override suspend fun getWordMeanings(word: String): Result<List<Word>, Error> {
        TODO("Not yet implemented")
    }
}