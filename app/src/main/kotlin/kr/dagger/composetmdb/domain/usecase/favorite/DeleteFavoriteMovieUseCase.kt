package kr.dagger.composetmdb.domain.usecase.favorite

import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class DeleteFavoriteMovieUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCaseSuspend<Long, Unit>() {

	override suspend fun execute(params: Long) {
		favoriteRepository.deleteFavoriteMovie(params)
	}
}