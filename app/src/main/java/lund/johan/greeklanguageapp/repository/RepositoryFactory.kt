package lund.johan.greeklanguageapp.repository

import dagger.Component
import lund.johan.greeklanguageapp.database.GreekDatabase

@Component
interface RepositoryFactory {
    fun repo(): Repository;
}