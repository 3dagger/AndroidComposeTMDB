package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import kr.dagger.nuyhoostmdb.core.model.UpComing

interface MovieRepository {

	fun getUpComingMovies(): Flow<List<UpComing>>

	fun getNoPlayingMovies(): Flow<List<NowPlaying>>

	fun getMovieDetail(id: Int): Flow<Detail>
}