package kr.dagger.composetmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.composetmdb.core.data.repository.MovieRepository
import kr.dagger.composetmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.composetmdb.core.model.Popular
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCaseSuspend<Unit, Flow<List<Popular>>>() {

	override suspend fun execute(params: Unit): Flow<List<Popular>> {
		return flow {  }
	}
}