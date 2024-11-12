package com.dm.berxley.dictionary.dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val word: String,
    val phonetic: String,
)
