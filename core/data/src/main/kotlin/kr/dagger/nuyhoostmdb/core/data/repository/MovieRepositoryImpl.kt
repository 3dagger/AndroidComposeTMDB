package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.nuyhoostmdb.core.data.mapper.DetailMapper
import kr.dagger.nuyhoostmdb.core.data.mapper.NowPlayingMapper
import kr.dagger.nuyhoostmdb.core.data.mapper.UpComingMapper
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import kr.dagger.nuyhoostmdb.core.model.UpComing
import kr.dagger.nuyhoostmdb.core.network.service.MovieService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
	private val movieService: MovieService
) : MovieRepository {

	override fun getNoPlayingMovies(): Flow<List<NowPlaying>> {
		return flow {
			emit(
				movieService.getNowPlaying().results.map {
					NowPlayingMapper.mapFromNowPlayingResponseToModel(it)
				}
			)
		}
	}

	override fun getUpComingMovies(): Flow<List<UpComing>> {
		return flow {
			emit(
				movieService.getUpComing().results.map {
					UpComingMapper.mapFromUpComingResponseToModel(it)
				}
			)
		}
	}

	override fun getMovieDetail(id: Int): Flow<Detail> {
		return flow {
			emit(
				DetailMapper.mapFromDetailResponseToModel(movieService.getDetail(id))
			)
		}
	}
}