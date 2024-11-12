package com.dm.berxley.dictionary.dictionary.data.remote.dtos

data class MeaningDto(
    val partOfSpeech: String,
    val antonyms: List<String>,
    val synonyms: List<String>,
    val definitions: List<DefinitionDto>,
)