package kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark

import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import javax.inject.Inject

class DeleteBookmarkUseCase @Inject constructor(
	private val bookmarkRepository: BookmarkRepository
) : BaseUseCaseSuspend<Long, Unit>() {

	override suspend fun execute(params: Long) {
		bookmarkRepository.deleteBookmark(params)
	}
}