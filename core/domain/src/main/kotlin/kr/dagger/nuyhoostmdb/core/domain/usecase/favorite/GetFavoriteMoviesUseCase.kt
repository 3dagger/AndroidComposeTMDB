package kr.dagger.nuyhoostmdb.core.domain.usecase.favorite

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.Favorite
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, Flow<List<Favorite>>>() {

	override fun execute(params: Unit): Flow<List<Favorite>> {
		return favoriteRepository.getFavoriteMoviesFlow()
	}
}