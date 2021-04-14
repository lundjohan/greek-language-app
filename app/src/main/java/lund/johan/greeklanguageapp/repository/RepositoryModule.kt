package lund.johan.greeklanguageapp.repository

import dagger.Module
import dagger.Provides
import lund.johan.greeklanguageapp.database.GreekDatabase

@Module
class RepositoryModule {
    @Provides
    fun repository(): Repository{
        return Repository(GreekDatabase.getInstance()!!)
    }
}