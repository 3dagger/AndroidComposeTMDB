package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.nuyhoostmdb.core.model.Popular
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCaseSuspend<Unit, Flow<List<Popular>>>() {

	override suspend fun execute(params: Unit): Flow<List<Popular>> {
		return flow {  }
	}
}