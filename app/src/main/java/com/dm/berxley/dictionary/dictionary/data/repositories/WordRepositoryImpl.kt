package com.dm.berxley.dictionary.dictionary.data.repositories

import com.dm.berxley.dictionary.core.domain.util.Error
import com.dm.berxley.dictionary.core.domain.util.NetworkError
import com.dm.berxley.dictionary.core.domain.util.Result
import com.dm.berxley.dictionary.core.domain.util.map
import com.dm.berxley.dictionary.dictionary.data.local.WordDao
import com.dm.berxley.dictionary.dictionary.data.remote.WordApi
import com.dm.berxley.dictionary.dictionary.domain.models.Word
import com.dm.berxley.dictionary.dictionary.domain.repositories.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class WordRepositoryImpl(
    private val wordApi: WordApi,
    private val wordDao: WordDao
): WordRepository {
    override suspend fun getWordMeanings(word: String): Flow<Result<List<Word>, Error>> = flow {

        var wordInfos = wordDao.getWordInfos(word).map { it.toWord() }
        emit(Result.Success(wordInfos))


        try {

            val remoteWords = wordApi.getWordMeanings(word)

            wordDao.deleteWords(remoteWords.map { it.word })
            wordDao.insertWords(remoteWords.map { it.toWordEntity() })

            wordInfos = wordDao.getWordInfos(word).map { it.toWord() }
            emit(Result.Success(wordInfos))

        }catch (e: HttpException){
            emit(Result.Error(NetworkError.SERVER_ERROR))
        }catch (e: IOException){
            emit(Result.Error(NetworkError.NO_INTERNET))
        }

    }
}