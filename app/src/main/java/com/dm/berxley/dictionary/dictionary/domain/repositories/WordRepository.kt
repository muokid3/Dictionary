package com.dm.berxley.dictionary.dictionary.domain.repositories

import com.dm.berxley.dictionary.core.domain.util.Error
import com.dm.berxley.dictionary.core.domain.util.Result
import com.dm.berxley.dictionary.dictionary.domain.models.Word

interface WordRepository {
    suspend fun getWordMeanings(word: String): Result<List<Word>, Error>
}