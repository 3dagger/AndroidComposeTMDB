package kr.dagger.composetmdb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.data.local.FavoriteDao
import kr.dagger.composetmdb.data.paging.PopularMoviePagingSource
import kr.dagger.composetmdb.data.remote.MovieService
import kr.dagger.composetmdb.domain.model.Popular
import kr.dagger.composetmdb.domain.repository.PopularPagingRepository

class PopularPagingRepositoryImpl(
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