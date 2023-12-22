package kr.dagger.composetmdb.domain.usecase.favorite

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, Flow<List<Favorite>>>() {

	override fun execute(params: Unit): Flow<List<Favorite>> {
		return favoriteRepository.getFavoriteMoviesFlow()
	}
}