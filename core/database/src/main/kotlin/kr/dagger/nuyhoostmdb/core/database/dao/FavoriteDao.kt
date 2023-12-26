package kr.dagger.nuyhoostmdb.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.database.entity.FavoriteEntity

@Dao
interface FavoriteDao {

	@Query("SELECT * FROM favorite_movies ORDER BY id")
	fun getFavoriteMovies(): List<FavoriteEntity>

	@Query("SELECT * FROM favorite_movies ORDER BY id")
	fun getFavoriteMoviesFlow(): Flow<List<FavoriteEntity>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertFavoriteMovie(favoriteEntity: FavoriteEntity)

	@Query("DELETE FROM favorite_movies WHERE id = :id")
	fun deleteFavoriteMovie(id: Long)
}