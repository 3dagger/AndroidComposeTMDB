package kr.dagger.composetmdb.core.domain.usecase.favorite

import kr.dagger.composetmdb.core.data.repository.FavoriteRepository
import kr.dagger.composetmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.composetmdb.core.model.Favorite
import javax.inject.Inject

class InsertFavoriteMovieUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCaseSuspend<Favorite, Unit>() {

	override suspend fun execute(params: Favorite) {
		return favoriteRepository.insertFavoriteMovie(params)
	}
}