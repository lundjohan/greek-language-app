package lund.johan.greeklanguageapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import lund.johan.greeklanguageapp.database.entities.ChapterPart

@Dao
interface ChapterPartDao : DaoInterface{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(chapterPart: ChapterPart)

    @Query("SELECT * from chapter_part_table WHERE chapter_part_id = :key")
    suspend fun get(key: Long): ChapterPart?

    @Query("SELECT chapter_part_id FROM chapter_part_table ORDER BY chapter_part_id ASC")
    suspend override fun getAllOfTableIds():IntArray

    @Query("SELECT chapter_part_id FROM chapter_part_table WHERE chapter_id IS :chapterId")
    suspend fun getChapterPartIdsWithChapterId(chapterId: Int): IntArray
}