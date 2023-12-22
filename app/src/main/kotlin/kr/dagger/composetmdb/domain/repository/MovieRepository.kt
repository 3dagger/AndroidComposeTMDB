package kr.dagger.composetmdb.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.domain.model.Detail
import kr.dagger.composetmdb.domain.model.Popular

interface MovieRepository {

//	fun getPopularMovies(): Flow<List<Popular>>

	fun getMovieDetail(id: Int): Flow<Detail>
}