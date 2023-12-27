package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.nuyhoostmdb.core.model.NowPlaying
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCaseSuspend<Unit, Flow<List<NowPlaying>>>() {

	override suspend fun execute(params: Unit): Flow<List<NowPlaying>> {
		return movieRepository.getNoPlayingMovies()
	}
}