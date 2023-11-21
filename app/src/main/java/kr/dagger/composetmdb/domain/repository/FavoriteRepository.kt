package kr.dagger.composetmdb.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.data.local.Favorite

interface FavoriteRepository {

	fun getFavoriteMovies(): List<Favorite>

	fun getFavoriteMoviesFlow(): Flow<List<Favorite>>

	suspend fun insertFavoriteMovie(favorite: Favorite)

	suspend fun deleteFavoriteMovie(id: Long)
}