package kr.dagger.composetmdb.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.data.paging.PopularMoviePagingSource
import kr.dagger.composetmdb.core.model.Popular
import kr.dagger.composetmdb.core.network.service.MovieService
import javax.inject.Inject

class PopularPagingRepositoryImpl @Inject constructor(
	private val movieService: MovieService
) : PopularPagingRepository {

	companion object {
		private const val NETWORK_PAGE_SIZE = 20
	}

	override fun getPopularMovie(): Flow<PagingData<Popular>> {
		return Pager(
			config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
			pagingSourceFactory = { PopularMoviePagingSource(movieService) }
		).flow
	}
}