package com.dm.berxley.dictionary.dictionary.data.remote.dtos

data class WordResponseDto(
    var word: String,
    var phonetic: String,
    val meanings: List<MeaningDto>,
)