package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.dagger.nuyhoostmdb.core.database.dao.FavoriteDao
import kr.dagger.nuyhoostmdb.core.database.entity.FavoriteEntity
import kr.dagger.nuyhoostmdb.core.database.entity.asExternalModel
import kr.dagger.nuyhoostmdb.core.model.Favorite
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
	private val favoriteDao: FavoriteDao
) : FavoriteRepository {

	override fun getFavoriteMovies(): List<Favorite> {
		return favoriteDao.getFavoriteMovies()
			.map {
				it.asExternalModel()
			}
	}

	override fun getFavoriteMoviesFlow(): Flow<List<Favorite>> {
		return favoriteDao.getFavoriteMoviesFlow()
			.map {
				it.map(FavoriteEntity::asExternalModel)
			}
	}

	override suspend fun insertFavoriteMovie(favorite: Favorite) {
		return favoriteDao.insertFavoriteMovie(favoriteEntity = FavoriteEntity(
			id = favorite.id,
			title = favorite.title,
			posterPath = favorite.posterPath,
			overView = favorite.overView
		)
		)
	}

	override suspend fun deleteFavoriteMovie(id: Long){
		return favoriteDao.deleteFavoriteMovie(id = id)
	}
}