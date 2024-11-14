package com.dm.berxley.dictionary.dictionary.presentation.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.dictionary.core.domain.util.ApiErrorResponse
import com.dm.berxley.dictionary.core.domain.util.Result
import com.dm.berxley.dictionary.dictionary.domain.repositories.WordRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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


    fun onSearch(query: String) {
        _wordState.update {
            it.copy(isLoading = true)
        }
        _searchQuery.value = query.replace(" ", "")
        searchJob?.cancel()

        searchJob = viewModelScope.launch {
            delay(500L)

            wordRepository.getWordMeanings(query).collect { result ->

                when (result) {
                    is Result.Error -> {

                        _wordState.update {
                            it.copy(isLoading = false)
                        }
                        //emit error event here using channels
                        val errorMessage: ApiErrorResponse = result.error as ApiErrorResponse

                        Log.e("ERRR", errorMessage.message ?: "")
                    }

                    is Result.Success -> {
                        _wordState.update {
                            it.copy(isLoading = false, wordList = result.data)
                        }
                    }
                }

            }

        }
    }

}