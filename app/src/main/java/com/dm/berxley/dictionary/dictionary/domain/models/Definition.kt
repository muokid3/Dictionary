package com.dm.berxley.dictionary.dictionary.domain.models

data class Definition(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
)
