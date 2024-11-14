package com.dm.berxley.dictionary.dictionary.presentation.home

sealed interface DictionaryEvent {
    data class ShowSnack(val message: String): DictionaryEvent
}