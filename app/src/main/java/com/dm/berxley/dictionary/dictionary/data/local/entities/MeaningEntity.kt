package com.dm.berxley.dictionary.dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MeaningEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val wordId: Long,
    val antonyms: String,
    val partOfSpeech: String,
    val synonyms: String
)
