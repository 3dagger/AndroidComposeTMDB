package kr.dagger.composetmdb.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.domain.model.Detail
import kr.dagger.composetmdb.domain.repository.MovieRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCaseSuspend<Int, Flow<Detail>>() {

	override suspend fun execute(params: Int): Flow<Detail> {
		return movieRepository.getMovieDetail(id = params)
	}
}