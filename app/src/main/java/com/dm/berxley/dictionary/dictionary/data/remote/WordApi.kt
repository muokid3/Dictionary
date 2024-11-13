package com.dm.berxley.dictionary.dictionary.data.remote

import com.dm.berxley.dictionary.core.domain.util.NetworkError
import com.dm.berxley.dictionary.core.domain.util.Result
import com.dm.berxley.dictionary.dictionary.data.remote.dtos.WordResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface WordApi {

    @Headers("Content-Type: application/json")
    @GET("{word}")
    suspend fun getWordMeanings(@Path("word") word: String): List<WordResponseDto>


    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }
}