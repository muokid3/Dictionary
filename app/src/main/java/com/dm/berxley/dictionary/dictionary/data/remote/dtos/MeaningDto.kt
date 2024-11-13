package com.dm.berxley.dictionary.dictionary.data.remote.dtos

import com.dm.berxley.dictionary.dictionary.domain.models.Meaning
import com.dm.berxley.dictionary.dictionary.domain.models.Word

data class MeaningDto(
    val partOfSpeech: String,
    val antonyms: List<String>,
    val synonyms: List<String>,
    val definitions: List<DefinitionDto>,
){
    fun toMeaning(): Meaning {
        return Meaning(
            partOfSpeech = partOfSpeech,
            antonyms = antonyms,
            synonyms = synonyms,
            definitions = definitions.map { it.toDefinition() }
        )
    }
}