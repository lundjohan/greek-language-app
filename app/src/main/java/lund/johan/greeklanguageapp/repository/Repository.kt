package lund.johan.greeklanguageapp.repository

import android.widget.ImageView
import kotlinx.coroutines.*
import lund.johan.greeklanguageapp.database.GreekDatabase
import lund.johan.greeklanguageapp.database.dao.DaoInterface
import lund.johan.greeklanguageapp.database.entities.Chapter
import javax.inject.Inject

/**
 * Repository is currently only using database, but will also be calling remote in the future
 */
class Repository {
    lateinit var db: GreekDatabase;

    constructor() {}

    @Inject
    constructor(db: GreekDatabase) {
        this.db = db
    }
    /*val chapters: Array<ChapterTeaser> = arrayOf(
        ChapterTeaser(R.drawable.acropolis_5_3, "The Acropolis"),
        ChapterTeaser(R.drawable.greek_food_5_3, "Greek Food"),
        ChapterTeaser(R.drawable.mycenae_5_3, "Mycenae")
    )*/

    //chapters.size always same size as chapterParts.size. These will be linked tables in database
    /*val chapterPartsIds: Array<Array<Int>> = arrayOf(
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
    )*/

    /*val chapterParts:Array<ChapterTeaser> = arrayOf(
        ChapterTeaser(R.drawable.greece_flag_small, "1. Introduction"),
        ChapterTeaser(R.drawable.greece_flag_small, "2. The Acropolis"),
        ChapterTeaser(R.drawable.greece_flag_small, "3. The Acropolis"),
        ChapterTeaser(R.drawable.greece_flag_small, "1. Greek Food"),
        ChapterTeaser(R.drawable.greece_flag_small, "1. Mycenae"),
        ChapterTeaser(R.drawable.greece_flag_small, "2. Mycenae")
    )*/

    fun loadImageInto(id: Int, v: ImageView) {
        //v.setImageResource(chapters[id].imgId)
        CoroutineScope(Dispatchers.Main).launch {
            db.chapterDao.get(id.toLong())?.let { v.setImageResource(it.image) };
        }
    }

    fun getImgTxt(id: Int): String? {
        var title: String? =""
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                title = db.chapterDao.get(id.toLong())?.title
            }
            job.join()
        }
        return title
    }

    //this is only implemented becauce the extraction from db.chapterDao & chapterPartDao are so alike
    /*fun getImgTxtHelper(id: Int,typeOfDao: DaoInterface): String {
        lateinit var title: String
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                title = typeOfDao.get(id.toLong()).title
            }
            job.join()
        }
        return title
    }*/

    fun loadSmallImageInto(partid: Int, v: ImageView) {
        //v.setImageResource(chapterParts[partid].imgId)
        CoroutineScope(Dispatchers.Main).launch {
            db.chapterPartDao.get(partid.toLong())?.let { v.setImageResource(it.smallImage) };
        }
    }

    fun getSmallImgTxt(partid: Int): String? {
        var title: String? =""
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                title = db.chapterPartDao.get(partid.toLong())?.title
            }
            job.join()
        }
        return title
    }

    fun getAllChaptersIds(): IntArray {
        //return IntArray(chapters.size) { i -> i }
        lateinit var idsArr: IntArray
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                idsArr = db.chapterDao.getAllOfTableIds()
            }
            job.join()
        }
        return idsArr;
    }

    fun getAllChapterPartsIds(chapterId: Int): IntArray {
        //return IntArray(chapterPartsIds[chapterId].size){ i -> chapterPartsIds[chapterId][i]}
        lateinit var idsArr: IntArray
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                //idsArr = db.chapterPartDao.getAllOfTableIds()
                idsArr = db.chapterPartDao.getChapterPartIdsWithChapterId(chapterId)
            }
            job.join()
        }
        return idsArr;
    }

    fun getChapter(idChapter: Int): Chapter {
        lateinit var ch: Chapter
        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                ch = db.chapterDao.getChapter(idChapter)
            }
            job.join()
        }
        return ch;
    }
}