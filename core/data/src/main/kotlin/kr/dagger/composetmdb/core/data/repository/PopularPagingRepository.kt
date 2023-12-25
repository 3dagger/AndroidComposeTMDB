package kr.dagger.composetmdb.core.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.model.Popular

interface PopularPagingRepository {

	fun getPopularMovie(): Flow<PagingData<Popular>>
}