package lund.johan.greeklanguageapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import lund.johan.greeklanguageapp.database.entities.Chapter

@Dao
interface ChapterDao: DaoInterface{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(chapter: Chapter)

    @Query("SELECT * from chapter_table WHERE chapter_id = :key")
    suspend fun get(key: Long): Chapter?

    @Query("SELECT chapter_id FROM chapter_table ORDER BY chapter_id ASC")
    suspend override fun getAllOfTableIds():IntArray
//fun getAllChaptersIds(): LiveData<List<Long>>
}