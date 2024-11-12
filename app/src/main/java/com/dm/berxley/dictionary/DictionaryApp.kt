package com.dm.berxley.dictionary

import android.app.Application
import com.dm.berxley.dictionary.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DictionaryApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DictionaryApp)
            modules(AppModule)
        }
    }
}