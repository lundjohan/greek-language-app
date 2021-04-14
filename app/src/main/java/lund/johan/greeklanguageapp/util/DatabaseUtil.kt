package lund.johan.greeklanguageapp.util

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import lund.johan.greeklanguageapp.R
import lund.johan.greeklanguageapp.database.GreekDatabase
import lund.johan.greeklanguageapp.database.entities.Chapter
import lund.johan.greeklanguageapp.database.entities.ChapterPart

class DatabaseUtil {

    companion object {
        var TAG = DatabaseUtil::class.simpleName.toString()

        //clearAllTables is non-blocking so this we use runBlocking
        fun clearDatabase(db: GreekDatabase) = runBlocking<Unit> {
            GlobalScope.launch {
                db.clearAllTables()
            }

        }

        fun populateDatabase(db: GreekDatabase) {
            val chapters = listOf(
                Chapter(
                    0L, R.drawable.acropolis_5_3, "The Acropolis",
                    "Antigoni stands at the Acropololis to explain its buildings and history"
                ),
                Chapter(
                    1L, R.drawable.greek_food_5_3, "Greek Food",
                    "We try and talk about some Greek food"
                ),
                Chapter(
                    2L, R.drawable.mycenae_5_3, "Mycenae",
                    "We travel to the historic city of Mycenae and talk about it's history"
                )
            )

            val chapterParts = listOf(

                //Acropolis
                ChapterPart(0L, 0L, R.drawable.greece_flag_small, "1. Buck Bunny","https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"),
                ChapterPart(1L, 0L, R.drawable.greece_flag_small, "2. Antigonis Introduktion", null),
                ChapterPart(2L, 0L, R.drawable.greece_flag_small, "3. The Acropolis", null),

                //Greek Food
                ChapterPart(3L, 1L, R.drawable.greece_flag_small, "1. Greek Food", null),

                //Mycenae
                ChapterPart(4L, 2L, R.drawable.greece_flag_small, "1. Mycenae", null),
                ChapterPart(5L, 2L, R.drawable.greece_flag_small, "2. Mycenae", null),

                )

            GlobalScope.launch {
                //insert the chapters
                for (ch in chapters) {


                    Log.d(TAG, ch.chapterId.toString())
                    db.chapterDao.insert(ch);
                }

                //insert the chapterParts
                for (part in chapterParts) {
                    db.chapterPartDao.insert(part);
                }
            }

            /*val chapterId: Long,
            val picture: Int?,
            val title: String?,
            val info: String?*/
            //Create the ChapterParts

        }
    }

}