package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.model.Search
import javax.inject.Inject

class GetMovieSearchUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCase<String, Flow<Search>>() {
	override fun execute(params: String): Flow<Search> {
		return movieRepository.getMovieSearch(params)
	}
}