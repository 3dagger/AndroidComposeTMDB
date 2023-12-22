package kr.dagger.composetmdb.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.database.entity.Favorite

@Dao
interface FavoriteDao {

	@Query("SELECT * FROM favorite_movies ORDER BY id")
	fun getFavoriteMovies(): List<Favorite>

	@Query("SELECT * FROM favorite_movies ORDER BY id")
	fun getFavoriteMoviesFlow(): Flow<List<Favorite>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertFavoriteMovie(favorite: Favorite)

	@Query("DELETE FROM favorite_movies WHERE id = :id")
	fun deleteFavoriteMovie(id: Long)
}