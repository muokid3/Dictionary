package com.dm.berxley.dictionary.dictionary.data.remote.dtos

data class DefinitionDto(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
)