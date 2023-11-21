package kr.dagger.composetmdb.data.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.data.local.FavoriteDao
import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
	private val favoriteDao: FavoriteDao
) : FavoriteRepository {

	override fun getFavoriteMovies(): List<Favorite> {
		return favoriteDao.getFavoriteMovies()
	}

	override fun getFavoriteMoviesFlow(): Flow<List<Favorite>> {
		return favoriteDao.getFavoriteMoviesFlow()
	}

	override suspend fun insertFavoriteMovie(favorite: Favorite) {
		return favoriteDao.insertFavoriteMovie(favorite = favorite)
	}

	override suspend fun deleteFavoriteMovie(id: Long) {
		return favoriteDao.deleteFavoriteMovie(id = id)
	}
}