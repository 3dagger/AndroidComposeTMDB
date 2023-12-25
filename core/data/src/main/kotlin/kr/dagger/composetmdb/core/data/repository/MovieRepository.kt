package kr.dagger.composetmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.model.Detail

interface MovieRepository {

	fun getMovieDetail(id: Int): Flow<Detail>
}