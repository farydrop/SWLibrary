package com.example.swlibrary.di

import android.app.Application
import androidx.room.Room
import com.example.swlibrary.data.local.AppDatabase
import com.example.swlibrary.data.local.CharacterDao
import com.example.swlibrary.data.local.PlanetDao
import com.example.swlibrary.data.local.StarWarsDao
import com.example.swlibrary.data.local.StarshipDao
import org.koin.dsl.module

val daoModule = module {
    single { createDataBase(get()) }
    single { createStarWarsDao(get()) }
    /*single { createPlanetDao(get()) }
    single { createStarshipDao(get()) }*/
}

private fun createDataBase(app: Application): AppDatabase =
    Room
        .databaseBuilder(app, AppDatabase::class.java, "AppDatabase")
        .build()

private fun createStarWarsDao(database: AppDatabase): StarWarsDao =
    database.starWarsDao()

/*
private fun createPlanetDao(database: AppDatabase): PlanetDao =
    database.planetDao()

private fun createStarshipDao(database: AppDatabase): StarshipDao =
    database.starshipDao()*/
