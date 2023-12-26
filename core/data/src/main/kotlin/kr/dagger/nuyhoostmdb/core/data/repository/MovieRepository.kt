package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.model.Detail

interface MovieRepository {

	fun getMovieDetail(id: Int): Flow<Detail>
}