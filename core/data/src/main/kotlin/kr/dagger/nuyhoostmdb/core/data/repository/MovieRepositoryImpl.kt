package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.nuyhoostmdb.core.data.mapper.DetailMapper
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.network.service.MovieService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
	private val movieService: MovieService
) : MovieRepository {

//	override fun getPopularMovies(): Flow<List<Popular>> {
//		return flow {
//			emit(
//				movieService.getPopular().results.map {
//					PopularMapper.mapFromPopularResponseToModel(it)
//				}
//			)
//		}
//	}

	override fun getMovieDetail(id: Int): Flow<Detail> {
		return flow {
			emit(
				DetailMapper.mapFromDetailResponseToModel(movieService.getDetail(id))
			)
		}
	}
}