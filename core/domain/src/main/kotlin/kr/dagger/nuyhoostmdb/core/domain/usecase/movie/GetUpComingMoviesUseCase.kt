package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.UpComing
import javax.inject.Inject

class GetUpComingMoviesUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCase<Unit, Flow<List<UpComing>>>() {

	override fun execute(params: Unit): Flow<List<UpComing>> {
		return movieRepository.getUpComingMovies()
	}
}