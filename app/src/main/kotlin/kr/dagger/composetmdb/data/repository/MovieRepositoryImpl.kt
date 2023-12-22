package kr.dagger.composetmdb.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.composetmdb.data.remote.MovieService
import kr.dagger.composetmdb.data.remote.mapper.DetailMapper
import kr.dagger.composetmdb.data.remote.mapper.PopularMapper
import kr.dagger.composetmdb.domain.model.Detail
import kr.dagger.composetmdb.domain.model.Popular
import kr.dagger.composetmdb.domain.repository.MovieRepository

class MovieRepositoryImpl(
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