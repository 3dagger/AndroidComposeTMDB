package kr.dagger.composetmdb.core.domain.usecase.favorite

import kr.dagger.composetmdb.core.data.repository.FavoriteRepository
import kr.dagger.composetmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.composetmdb.core.model.Favorite
import javax.inject.Inject

class GetFavo @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, List<Favorite>>() {

	override fun execute(params: Unit): List<Favorite> {
		return favoriteRepository.getFavoriteMovies()
	}
}