package kr.dagger.composetmdb.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.domain.model.Popular

interface PopularPagingRepository {

	fun getPopularMovie(): Flow<PagingData<Popular>>
}