package kr.dagger.composetmdb.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.dagger.composetmdb.core.database.dao.FavoriteDao
import kr.dagger.composetmdb.core.database.entity.FavoriteEntity

@Database(
	entities = [FavoriteEntity::class], version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

	abstract fun favoriteDao(): FavoriteDao

//	companion object {
//
//		@Volatile private var instance: AppDatabase? = null
//
//		fun getInstance(context: Context): AppDatabase {
//			return instance ?: synchronized(this) {
//				instance ?: buildDatabase(context).also { instance = it }
//			}
//		}
//
//		private fun buildDatabase(context: Context): AppDatabase {
//			return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
//				.build()
//		}
//	}
}