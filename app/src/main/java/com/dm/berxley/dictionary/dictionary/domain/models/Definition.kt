package com.dm.berxley.dictionary.dictionary.domain.models

data class Definition(
    val id: Long,
    val meaningId: Long,
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
)
