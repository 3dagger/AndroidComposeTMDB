package kr.dagger.nuyhoostmdb.core.domain.usecase.favorite

import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class DeleteFavoriteMovieUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCaseSuspend<Long, Unit>() {

	override suspend fun execute(params: Long) {
		favoriteRepository.deleteFavoriteMovie(params)
	}
}