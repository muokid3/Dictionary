package com.dm.berxley.dictionary.dictionary.presentation.home

import com.dm.berxley.dictionary.dictionary.domain.models.Word

data class WordState(
    val wordList: List<Word> = emptyList(),
    val isLoading: Boolean = false
)
