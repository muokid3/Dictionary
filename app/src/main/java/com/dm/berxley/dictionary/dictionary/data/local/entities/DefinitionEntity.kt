package com.dm.berxley.dictionary.dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DefinitionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val meaningId: Long,
    val definition: String,
    val example: String,
    val synonyms: String,
)
