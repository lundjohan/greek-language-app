package lund.johan.greeklanguageapp.repository

import dagger.Component
import lund.johan.greeklanguageapp.database.di.DatabaseModule

@Component(modules = [DatabaseModule::class, RepositoryModule::class])
interface RepositoryFactory {
    fun repo():Repository
}