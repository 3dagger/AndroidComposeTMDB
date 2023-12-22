package kr.dagger.composetmdb.domain.usecase.favorite

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class GetFavo @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, List<Favorite>>() {

	override fun execute(params: Unit): List<Favorite> {
		return favoriteRepository.getFavoriteMovies()
	}
}