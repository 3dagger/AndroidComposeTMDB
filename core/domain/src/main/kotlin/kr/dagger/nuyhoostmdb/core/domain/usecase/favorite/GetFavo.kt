package kr.dagger.nuyhoostmdb.core.domain.usecase.favorite

import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.Favorite
import javax.inject.Inject

class GetFavo @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, List<Favorite>>() {

	override fun execute(params: Unit): List<Favorite> {
		return favoriteRepository.getFavoriteMovies()
	}
}