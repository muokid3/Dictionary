package com.dm.berxley.dictionary.dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
class ListToStringConverter {
    @TypeConverter
    fun listToString(list: List<String>): String {
        return list.joinToString(separator = ",")
    }

    @TypeConverter
    fun stringToList(string: String): List<String> {
        return string.split(",")
    }
}

