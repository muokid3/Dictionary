package com.dm.berxley.dictionary.core.domain.util

data class ApiErrorResponse(
    val title: String? = null,
    val message: String? = null,
    val resolution: String? = null,
) : Error
