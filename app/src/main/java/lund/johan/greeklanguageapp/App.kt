package lund.johan.greeklanguageapp

import android.app.Application
import lund.johan.greeklanguageapp.database.GreekDatabase
import lund.johan.greeklanguageapp.database.di.DaggerDatabaseComponent
import lund.johan.greeklanguageapp.database.di.DatabaseModule
import lund.johan.greeklanguageapp.util.DatabaseUtil

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //Database is created only once and here => Singleton
        GreekDatabase.initiateDB(applicationContext);
        val db = GreekDatabase.getInstance()!!
        //DatabaseUtil.clearDatabase(db);
        DatabaseUtil.populateDatabase(db);
    }
}