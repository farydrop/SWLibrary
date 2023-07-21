package com.example.swlibrary.di

import com.example.swlibrary.data.local.StarWarsRepository
import com.example.swlibrary.data.local.StarWarsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single <StarWarsRepository> { StarWarsRepositoryImpl(get()) }
}