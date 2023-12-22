package kr.dagger.composetmdb.domain.usecase.favorite

import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class InsertFavoriteMovieUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCaseSuspend<Favorite, Unit>() {

	override suspend fun execute(params: Favorite) {
		return favoriteRepository.insertFavoriteMovie(params)
	}
}