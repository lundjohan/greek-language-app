package lund.johan.greeklanguageapp.repository

import android.widget.ImageView
import lund.johan.greeklanguageapp.R
import lund.johan.greeklanguageapp.chapterItems.ChapterTeaser
import lund.johan.greeklanguageapp.repository.Repository.chapterParts

/*
Temporary fake Repository, but will be calling remote and database in the future
 */
object Repository {
    val chapters: Array<ChapterTeaser> = arrayOf(
        ChapterTeaser(R.drawable.acropolis_5_3, "The Acropolis"),
        ChapterTeaser(R.drawable.greek_food_5_3, "Greek Food"),
        ChapterTeaser(R.drawable.mycenae_5_3, "Mycenae")
    )

    //chapters.size always same size as chapterParts.size. These will be linked tables in database
    val chapterPartsIds: Array<Array<Int>> = arrayOf(
        //acropolis parts
        arrayOf(
            0,1,2
        ),
        //greek food
        arrayOf(
            3
        ),
        //mycenae
        arrayOf(
            4,5
        )
    )

    val chapterParts:Array<ChapterTeaser> = arrayOf(
        ChapterTeaser(R.drawable.greece_flag_small, "1. The Acropolis"),
        ChapterTeaser(R.drawable.greece_flag_small, "2. The Acropolis"),
        ChapterTeaser(R.drawable.greece_flag_small, "3. The Acropolis"),
        ChapterTeaser(R.drawable.greece_flag_small, "1. Greek Food"),
        ChapterTeaser(R.drawable.greece_flag_small, "1. Mycenae"),
        ChapterTeaser(R.drawable.greece_flag_small, "2. Mycenae")
    )

    fun loadImageInto(id: Int, v: ImageView) {
        v.setImageResource(chapters[id].imgId)
    }

    fun getImgTxt(id: Int): String {
        return chapters[id].txt
    }
    fun loadSmallImageInto(partid: Int, v: ImageView) {
        v.setImageResource(chapterParts[partid].imgId)
    }

    fun getSmallImgTxt(partid:Int): String{
        return chapterParts[partid].txt
    }

    /*
Methods are banal right now,
  but in future (when using database or remote) can happen that some ids in the middle are missing
 */
    fun getAllChaptersIds(): IntArray {
        return IntArray(chapters.size) { i -> i }
    }
    fun getAllChapterPartsIds(chapterId:Int): IntArray {
        return IntArray(chapterPartsIds[chapterId].size){ i -> chapterPartsIds[chapterId][i]}
    }
}