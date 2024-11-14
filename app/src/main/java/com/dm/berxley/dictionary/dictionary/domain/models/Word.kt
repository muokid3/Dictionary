package com.dm.berxley.dictionary.dictionary.domain.models


data class Word(
    val word: String,
    val phonetic: String? = null,
    val meanings: List<Meaning>,
)
