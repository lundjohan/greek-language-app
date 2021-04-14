package lund.johan.greeklanguageapp.database.dao

import lund.johan.greeklanguageapp.database.entities.Chapter

interface DaoInterface {
    suspend fun getAllOfTableIds():IntArray
}
