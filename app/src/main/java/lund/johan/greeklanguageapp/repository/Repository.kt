package lund.johan.greeklanguageapp.repository

import android.widget.ImageView
import lund.johan.greeklanguageapp.R
import lund.johan.greeklanguageapp.chapterItems.ChapterTeaser

/*
Temporary "fake" Repository, but will be calling remote and/ or database in the future
 */
object Repository {
    val dataset: Array<ChapterTeaser> = arrayOf(
        ChapterTeaser(R.drawable.acropolis_5_3, "The Acropolis"),
        ChapterTeaser(R.drawable.greek_food_5_3, "Greek Food"),
        ChapterTeaser(R.drawable.mycenae_5_3, "Mycenae")
    )

    fun loadImageInto(id: Int, v: ImageView) {
        v.setImageResource(dataset[id].imgId)
    }

    fun getImgTxt(id: Int): String {
        return dataset[id].txt
    }

    /*
Method is banal right now,
  but in future (when using database or remote) can happen that some ids in the middle are missing
 */
    fun getAllIds(): IntArray {
        return IntArray(dataset.size) { i -> i }
    }
}