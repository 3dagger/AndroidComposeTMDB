package kr.dagger.nuyhoostmdb.core.domain.usecase.favorite

import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.nuyhoostmdb.core.model.Favorite
import javax.inject.Inject

class InsertFavoriteMovieUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCaseSuspend<Favorite, Unit>() {

	override suspend fun execute(params: Favorite) {
		return favoriteRepository.insertFavoriteMovie(params)
	}
}