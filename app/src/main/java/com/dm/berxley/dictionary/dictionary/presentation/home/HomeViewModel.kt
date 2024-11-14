package com.dm.berxley.dictionary.dictionary.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.dictionary.core.domain.util.ApiErrorResponse
import com.dm.berxley.dictionary.core.domain.util.Result
import com.dm.berxley.dictionary.dictionary.domain.repositories.WordRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val wordRepository: WordRepository
) : ViewModel() {
    private var _searchQuery = mutableStateOf("")
    var searchQuery = _searchQuery

    private val _wordState = MutableStateFlow(WordState())
    val wordState = _wordState.asStateFlow()

    private var searchJob: Job? = null

    private val _dictionaryEventsChannel = Channel<DictionaryEvent>()
    val dictionaryEventsChannel = _dictionaryEventsChannel.receiveAsFlow()


    fun onSearch(q: String) {

        searchJob?.cancel()
        _wordState.update {
            it.copy(isLoading = true)
        }
        _searchQuery.value = q


        searchJob = viewModelScope.launch {

            delay(500L)
            val query = q.trim()

            if (query.isNotEmpty()) {
                _wordState.update {
                    it.copy(isLoading = true)
                }

                wordRepository.getWordMeanings(query).collect { result ->

                    when (result) {
                        is Result.Error -> {

                            _wordState.update {
                                it.copy(isLoading = false)
                            }
                            //emit error event here using channels
                            val errorMessage: ApiErrorResponse = result.error as ApiErrorResponse
                            val msg =
                                if (!errorMessage.title.isNullOrEmpty()) errorMessage.title else {
                                    ""
                                } + " " + if (!errorMessage.message.isNullOrEmpty()) errorMessage.message else {
                                    ""
                                } + " " + if (!errorMessage.resolution.isNullOrEmpty()) errorMessage.resolution else {
                                    ""
                                }
                            _dictionaryEventsChannel.send(DictionaryEvent.ShowSnack(message = msg))
                        }

                        is Result.Success -> {
                            _wordState.update {
                                it.copy(isLoading = false, wordList = result.data)
                            }
                        }
                    }

                }
            } else {
                _wordState.update {
                    it.copy(isLoading = false)
                }
            }
        }
    }

}