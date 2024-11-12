package com.dm.berxley.dictionary.dictionary.domain.models


data class Word(
    val id: Long,
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
)
