package kr.dagger.composetmdb.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kr.dagger.composetmdb.domain.model.Popular
import kr.dagger.composetmdb.domain.repository.MovieRepository
import kr.dagger.composetmdb.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCaseSuspend<Unit, Flow<List<Popular>>>() {

	override suspend fun execute(params: Unit): Flow<List<Popular>> {
		return flow {  }
	}
}