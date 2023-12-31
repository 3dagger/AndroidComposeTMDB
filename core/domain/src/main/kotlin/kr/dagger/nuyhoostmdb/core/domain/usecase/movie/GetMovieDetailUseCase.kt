package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.data.repository.MovieRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCase
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.nuyhoostmdb.core.model.Detail
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
	private val movieRepository: MovieRepository
) : BaseUseCase<Int, Flow<Detail>>() {

	override fun execute(params: Int): Flow<Detail> {
		return movieRepository.getMovieDetail(id = params)
	}
}