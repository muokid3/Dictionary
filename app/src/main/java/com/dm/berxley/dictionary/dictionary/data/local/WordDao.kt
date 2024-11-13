package com.dm.berxley.dictionary.dictionary.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dm.berxley.dictionary.dictionary.data.local.entities.WordEntity

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(words: List<WordEntity>)

    @Query("SELECT * FROM WordEntity where word LIKE :word")
    suspend fun getWordInfos(word: String): List<WordEntity>

    @Query("DELETE FROM WordEntity WHERE word IN(:wordList)")
    suspend fun deleteWords(wordList: List<String>)


}