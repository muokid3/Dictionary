package com.dm.berxley.dictionary.dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dm.berxley.dictionary.dictionary.domain.models.Meaning
import com.dm.berxley.dictionary.dictionary.domain.models.Word

@Entity
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
){
    fun toWord(): Word{
        return Word(
            word = word,
            phonetic = phonetic,
            meanings = meanings
        )
    }
}
