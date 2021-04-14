package lund.johan.greeklanguageapp.database.di

import dagger.Module
import dagger.Provides
import lund.johan.greeklanguageapp.database.GreekDatabase

@Module
class DatabaseModule{
    @Provides
    fun database(): GreekDatabase {
        return GreekDatabase.getInstance()!!;
    }
}