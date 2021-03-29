package com.emmagcarbontest.app.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.emmagcarbontest.restapi.models.User
import com.emmagcarbontest.app.local.dao.UserDao


@Database(entities = [User::class], version = 1, exportSchema = true)

@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /*** Before creating the database, we have to make sure that it is encrypted. We use SQLCipher
         * to accomplish this.
         * Useful links: https://medium.com/@sonique6784/protect-your-room-database-with-sqlcipher-on-android-78e0681be687
         * https://stackoverflow.com/questions/62770394/is-android-room-database-secure-to-store-sensitive-data
         * https://github.com/sqlcipher/android-database-sqlcipher#using-sqlcipher-for-android-with-room
         * https://medium.com/vmware-end-user-computing/securing-a-room-database-with-passcode-based-encryption-82ec670961e
         */
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }


    }


}