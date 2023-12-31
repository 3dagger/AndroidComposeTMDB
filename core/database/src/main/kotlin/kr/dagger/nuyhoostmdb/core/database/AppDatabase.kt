package kr.dagger.nuyhoostmdb.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.dagger.nuyhoostmdb.core.database.dao.BookmarkDao
import kr.dagger.nuyhoostmdb.core.database.entity.BookmarkEntity

@Database(
	entities = [BookmarkEntity::class], version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

	abstract fun bookmarkDao(): BookmarkDao
}