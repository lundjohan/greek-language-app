package lund.johan.greeklanguageapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lund.johan.greeklanguageapp.database.dao.ChapterDao
import lund.johan.greeklanguageapp.database.dao.ChapterPartDao
import lund.johan.greeklanguageapp.database.entities.Chapter
import lund.johan.greeklanguageapp.database.entities.ChapterPart
import javax.inject.Inject

/**
 * A Room Database
 * Based on https://developer.android.com/codelabs/kotlin-android-training-room-database
 *
 * This is a Singleton class thanks to the companion object
 */
@Database(entities = arrayOf(Chapter::class, ChapterPart::class), version = 1, exportSchema = false)
abstract class GreekDatabase : RoomDatabase() {
    abstract val chapterDao: ChapterDao
    abstract val chapterPartDao: ChapterPartDao

    companion object {


        @Volatile
        private var INSTANCE: GreekDatabase? = null

        fun initiateDB(context: Context)
        {
            synchronized(this) {
                //copy to local value (smart cast is only available to local variables)
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        GreekDatabase::class.java,
                        "greek_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
            }
        }

        fun getInstance(): GreekDatabase? {
            synchronized(this) {
                //copy to local value (smart cast is only available to local variables)
                var instance = INSTANCE
                return instance

            }
        }

    }

}