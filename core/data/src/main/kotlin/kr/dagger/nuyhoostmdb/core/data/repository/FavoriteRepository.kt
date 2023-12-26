package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.model.Favorite


interface FavoriteRepository {

	fun getFavoriteMovies(): List<Favorite>

	fun getFavoriteMoviesFlow(): Flow<List<Favorite>>

	suspend fun insertFavoriteMovie(favoriteEntity: Favorite)

	suspend fun deleteFavoriteMovie(id: Long)
}