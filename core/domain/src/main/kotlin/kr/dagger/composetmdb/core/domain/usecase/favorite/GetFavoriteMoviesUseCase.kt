package kr.dagger.composetmdb.core.domain.usecase.favorite

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.data.repository.FavoriteRepository
import kr.dagger.composetmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.composetmdb.core.model.Favorite
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, Flow<List<Favorite>>>() {

	override fun execute(params: Unit): Flow<List<Favorite>> {
		return favoriteRepository.getFavoriteMoviesFlow()
	}
}