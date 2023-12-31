package kr.dagger.nuyhoostmdb.core.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.model.Movie

interface PopularPagingRepository {

	fun getPopularMovie(): Flow<PagingData<Movie>>
}