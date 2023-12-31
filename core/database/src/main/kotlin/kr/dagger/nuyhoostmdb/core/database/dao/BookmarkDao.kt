package kr.dagger.nuyhoostmdb.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.database.entity.BookmarkEntity

@Dao
interface BookmarkDao {

	@Query("SELECT * FROM bookmark_movies ORDER BY id")
	fun getFavoriteMovies(): List<BookmarkEntity>

	@Query("SELECT * FROM bookmark_movies ORDER BY id")
	fun getBookmarks(): Flow<List<BookmarkEntity>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertBookmark(bookmarkEntity: BookmarkEntity)

	@Query("DELETE FROM bookmark_movies WHERE id = :id")
	fun deleteBookmark(id: Long)
}