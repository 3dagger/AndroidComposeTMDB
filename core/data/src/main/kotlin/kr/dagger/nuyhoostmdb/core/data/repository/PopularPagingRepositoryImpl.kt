package kr.dagger.nuyhoostmdb.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.paging.PopularMoviePagingSource
import kr.dagger.nuyhoostmdb.core.model.Movie
import kr.dagger.nuyhoostmdb.core.network.service.MovieService
import javax.inject.Inject

class PopularPagingRepositoryImpl @Inject constructor(
	private val movieService: MovieService
) : PopularPagingRepository {

	companion object {
		private const val NETWORK_PAGE_SIZE = 20
	}

	override fun getPopularMovie(): Flow<PagingData<Movie>> {
		return Pager(
			config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
			pagingSourceFactory = { PopularMoviePagingSource(movieService) }
		).flow
	}
}