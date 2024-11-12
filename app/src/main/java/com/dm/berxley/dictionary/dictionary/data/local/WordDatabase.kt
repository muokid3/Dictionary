package com.dm.berxley.dictionary.dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dm.berxley.dictionary.dictionary.data.local.entities.DefinitionEntity
import com.dm.berxley.dictionary.dictionary.data.local.entities.MeaningEntity
import com.dm.berxley.dictionary.dictionary.data.local.entities.WordEntity

@Database(
    entities = [WordEntity::class, MeaningEntity::class, DefinitionEntity::class],
    version = 1
)
@TypeConverters(ListToStringConverter::class)
abstract class WordDatabase : RoomDatabase() {
    abstract val wordDao: WordDao

    companion object {
        const val ROOM_DB_NAME = "dictionary_database"
    }
}