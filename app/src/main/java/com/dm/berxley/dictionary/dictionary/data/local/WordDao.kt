package com.dm.berxley.dictionary.dictionary.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dm.berxley.dictionary.dictionary.data.local.entities.WordEntity

interface WordDao {

    @Insert
    suspend fun insertWord(word: WordEntity)


    @Query("DELETE from WordEntity where word = :word")
    suspend fun deleteWords(word: String)

    @Query("DELETE from MeaningEntity where wordId = :wordId")
    suspend fun deleteMeanings(wordId: Long)

    @Query("DELETE from DefinitionEntity where meaningId = :meaningId")
    suspend fun deleteDefinitions(meaningId: Long)

}