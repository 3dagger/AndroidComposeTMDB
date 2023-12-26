package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.FavoriteRepository
import kr.dagger.nuyhoostmdb.core.data.repository.PopularPagingRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.Popular
import javax.inject.Inject

class GetPopularMoviePagingUseCase @Inject constructor(
	private val popularPagingRepository: PopularPagingRepository,
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, Flow<PagingData<Popular>>>() {

	override fun execute(params: Unit): Flow<PagingData<Popular>> {
		return popularPagingRepository.getPopularMovie()
	}
}