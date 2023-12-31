package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.data.repository.PopularPagingRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.Movie
import javax.inject.Inject

class GetPopularMoviePagingUseCase @Inject constructor(
	private val popularPagingRepository: PopularPagingRepository,
	private val bookmarkRepository: BookmarkRepository
) : BaseUseCase<Unit, Flow<PagingData<Movie>>>() {

	override fun execute(params: Unit): Flow<PagingData<Movie>> {
		return popularPagingRepository.getPopularMovie()
	}
}