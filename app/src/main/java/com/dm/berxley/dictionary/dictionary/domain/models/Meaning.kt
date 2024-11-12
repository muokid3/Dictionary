package com.dm.berxley.dictionary.dictionary.domain.models


data class Meaning(
    val id: Long,
    val wordId: Long,
    val antonyms: List<String>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
)
