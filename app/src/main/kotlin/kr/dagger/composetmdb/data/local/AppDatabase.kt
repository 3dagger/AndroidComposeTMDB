package kr.dagger.composetmdb.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kr.dagger.composetmdb.utility.DATABASE_NAME

@Database(
	entities = [Favorite::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

	abstract fun favoriteDao(): FavoriteDao

	companion object {

		@Volatile private var instance: AppDatabase? = null

		fun getInstance(context: Context): AppDatabase {
			return instance ?: synchronized(this) {
				instance ?: buildDatabase(context).also { instance = it }
			}
		}

		private fun buildDatabase(context: Context): AppDatabase {
			return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
				.build()
		}
	}
}