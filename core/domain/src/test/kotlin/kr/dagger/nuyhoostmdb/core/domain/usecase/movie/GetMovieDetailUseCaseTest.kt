package kr.dagger.nuyhoostmdb.core.domain.usecase.movie

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kr.dagger.nuyhoostmdb.core.model.Detail
import kr.dagger.nuyhoostmdb.core.testing.MainDispatcherRule
import kr.dagger.nuyhoostmdb.core.testing.respository.TestMovieRepository
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class GetMovieDetailUseCaseTest {

	@get:Rule
	val mainDispatcherRule = MainDispatcherRule()

	private val movieRepository = TestMovieRepository()

	private val useCase = GetMovieDetailUseCase(
		movieRepository = movieRepository
	)

	@Test
	fun when_hasParams_invoke_method_return_testDetail() = runTest {
		val execute = useCase.execute(1014590)

		assertEquals(
			execute.first(),
			testDetail
		)
	}
}

private val testDetail = Detail(
	id = 1014590,
	adult = false,
	backdropPath = "/pRmF6VBsRnvWCbLB9P80UvZFMyK.jpg",
	genre = listOf(),
	originalTitle = "Upgraded",
	overview = "미술 경매 회사의 인턴 아나는 막판에 상사와의 출장 동행이 결정되어 런던으로 향하려던 차 일등석으로 비행기표를 업그레이드 받는다. 편안한 일등석 좌석에 자리를 잡던 아나는 잘생기고 부유한 윌리엄을 만난 뒤 자신의 환상을 조금 더 즐겨 보기로 한다.",
	popularity = 388.489,
	posterPath = "/9xn7y63VIpUsIVzSP9fYrqJHyl9.jpg",
	releaseDate = "2024-02-07",
	runTime = 190,
	status = "released",
	voteAverage = 5.5,
	voteCount = 9,
	isBookmarked = false
)