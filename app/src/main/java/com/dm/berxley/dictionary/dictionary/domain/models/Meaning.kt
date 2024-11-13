package com.dm.berxley.dictionary.dictionary.domain.models


data class Meaning(
    val partOfSpeech: String,
    val antonyms: List<String>,
    val synonyms: List<String>,
    val definitions: List<Definition>,
)
