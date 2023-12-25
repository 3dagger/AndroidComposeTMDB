package kr.dagger.composetmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kr.dagger.composetmdb.core.data.repository.MovieRepository
import kr.dagger.composetmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.composetmdb.core.model.Detail
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCaseSuspend<Int, Flow<Detail>>() {

	override suspend fun execute(params: Int): Flow<Detail> {
		return movieRepository.getMovieDetail(id = params)
	}
}