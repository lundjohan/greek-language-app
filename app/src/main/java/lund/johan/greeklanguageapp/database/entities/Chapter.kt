package lund.johan.greeklanguageapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chapter(
    @PrimaryKey @ColumnInfo(name = "chapter_id") val chapterId: Int,
    val picture: Int?,
    val title: String?,
    val info: String?
)
