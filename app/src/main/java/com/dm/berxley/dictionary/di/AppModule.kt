package com.dm.berxley.dictionary.di

import androidx.room.Room
import com.dm.berxley.dictionary.dictionary.data.local.ListToStringConverter
import com.dm.berxley.dictionary.dictionary.data.local.WordDatabase
import com.dm.berxley.dictionary.dictionary.data.remote.WordApi
import com.dm.berxley.dictionary.dictionary.data.repositories.WordRepositoryImpl
import com.dm.berxley.dictionary.dictionary.domain.repositories.WordRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = WordDatabase::class.java,
            name = WordDatabase.ROOM_DB_NAME
        )
            .addTypeConverter(ListToStringConverter::class)
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<WordDatabase>().wordDao }

    single {
        Retrofit.Builder()
            .baseUrl(WordApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(WordApi::class.java)
    }

    singleOf(::WordRepositoryImpl).bind<WordRepository>()
}