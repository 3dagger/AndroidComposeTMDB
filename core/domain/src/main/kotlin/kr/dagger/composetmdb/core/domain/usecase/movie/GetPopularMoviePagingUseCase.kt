package kr.dagger.composetmdb.core.domain.usecase.movie

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.data.repository.FavoriteRepository
import kr.dagger.composetmdb.core.data.repository.PopularPagingRepository
import kr.dagger.composetmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.composetmdb.core.model.Popular
import javax.inject.Inject

class GetPopularMoviePagingUseCase @Inject constructor(
	private val popularPagingRepository: PopularPagingRepository,
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, Flow<PagingData<Popular>>>() {

	override fun execute(params: Unit): Flow<PagingData<Popular>> {
		return popularPagingRepository.getPopularMovie()
	}
}