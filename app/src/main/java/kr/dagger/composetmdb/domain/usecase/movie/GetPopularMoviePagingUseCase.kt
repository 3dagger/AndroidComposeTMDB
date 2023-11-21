package kr.dagger.composetmdb.domain.usecase.movie

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.composetmdb.domain.model.Popular
import kr.dagger.composetmdb.domain.repository.FavoriteRepository
import kr.dagger.composetmdb.domain.repository.PopularPagingRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCase
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class GetPopularMoviePagingUseCase @Inject constructor(
	private val popularPagingRepository: PopularPagingRepository,
	private val favoriteRepository: FavoriteRepository
) : BaseUseCase<Unit, Flow<PagingData<Popular>>>() {

	override fun execute(params: Unit): Flow<PagingData<Popular>> {
		return popularPagingRepository.getPopularMovie()
	}
}