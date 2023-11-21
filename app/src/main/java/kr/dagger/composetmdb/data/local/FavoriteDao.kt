package kr.dagger.composetmdb.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

	@Query("SELECT * FROM favorite_movies ORDER BY id")
	fun getFavoriteMovies(): List<Favorite>

	@Query("SELECT * FROM favorite_movies ORDER BY id")
	fun getFavoriteMoviesFlow(): Flow<List<Favorite>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertFavoriteMovie(favorite: Favorite)

	@Query("DELETE FROM favorite_movies WHERE id = :id")
	suspend fun deleteFavoriteMovie(id: Long)
}