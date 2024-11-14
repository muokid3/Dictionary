package com.dm.berxley.dictionary.dictionary.data.remote.dtos

import com.dm.berxley.dictionary.dictionary.data.local.entities.WordEntity
import com.dm.berxley.dictionary.dictionary.domain.models.Word

data class WordResponseDto(
    var word: String,
    var phonetic: String? = null,
    val meanings: List<MeaningDto>,
){
    fun toWordEntity(): WordEntity {
        return WordEntity(
            word = word,
            phonetic = phonetic,
            meanings = meanings.map { it.toMeaning() }
        )
    }
}