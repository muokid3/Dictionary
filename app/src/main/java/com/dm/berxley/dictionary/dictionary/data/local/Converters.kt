package com.dm.berxley.dictionary.dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dm.berxley.dictionary.dictionary.data.util.JsonParser
import com.dm.berxley.dictionary.dictionary.domain.models.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromMeaningsJson(string: String): List<Meaning> {
        return jsonParser.fromJson(
            string,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }
}

