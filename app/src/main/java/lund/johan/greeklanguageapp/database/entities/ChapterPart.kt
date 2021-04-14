package lund.johan.greeklanguageapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "chapter_part_table",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Chapter::class,
            parentColumns = arrayOf("chapter_id"),
            childColumns = arrayOf("chapter_id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class ChapterPart (

    @PrimaryKey @ColumnInfo(name = "chapter_part_id")
    val chapterPartId: Long,

    @ColumnInfo(name = "chapter_id")
    val chapterId: Long,

    val smallImage: Int,

    val title: String?,

    //this will be null of this part doesn't refer to a video
    @ColumnInfo(name = "video_link")
    val videoLink: String?
)
