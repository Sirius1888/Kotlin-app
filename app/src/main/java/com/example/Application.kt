package com.example

import android.app.Application
import com.example.firstapp.di.mainModule
import com.example.firstapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
//            inject()
//            modules(listOf(repositoryModule, fragmentModule, viewModelModule, networkModule))
            modules(listOf(mainModule, viewModelModule))
        }
    }

    /*fun inject() = loadKoinModules

    private val loadKoinModules by lazy {
        loadKoinModules(listOf(repositoryModule, fragmentModule, viewModelModule, networkModule))
    }*/

}