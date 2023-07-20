package com.example.swlibrary

import android.app.Application
import com.example.swlibrary.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    /*val applicationScope = CoroutineScope(SupervisorJob())
    val dataBase by lazy { UserDataBase.getDatabase(this,applicationScope) }
    val repository by lazy { UserRepository(dataBase.userDao()) }*/

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules( viewModelModule )
        }
    }
}