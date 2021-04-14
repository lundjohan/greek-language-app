package lund.johan.greeklanguageapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapter_table")
data class Chapter(
    @PrimaryKey @ColumnInfo(name = "chapter_id")
    val chapterId: Long,
    val image: Int,
    val title: String?,
    val info: String?
)
