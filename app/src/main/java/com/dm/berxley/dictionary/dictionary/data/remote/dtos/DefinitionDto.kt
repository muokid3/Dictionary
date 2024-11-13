package com.dm.berxley.dictionary.dictionary.data.remote.dtos

import com.dm.berxley.dictionary.dictionary.domain.models.Definition
import com.dm.berxley.dictionary.dictionary.domain.models.Word

data class DefinitionDto(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
){
    fun toDefinition(): Definition {
        return Definition(
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}