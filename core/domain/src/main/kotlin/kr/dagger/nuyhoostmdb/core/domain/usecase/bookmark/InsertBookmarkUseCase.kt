package kr.dagger.nuyhoostmdb.core.domain.usecase.bookmark

import kr.dagger.nuyhoostmdb.core.data.repository.BookmarkRepository
import kr.dagger.nuyhoostmdb.core.domain.usecase.base.BaseUseCaseSuspend
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import javax.inject.Inject

class InsertBookmarkUseCase @Inject constructor(
	private val bookmarkRepository: BookmarkRepository
) : BaseUseCaseSuspend<Bookmark, Unit>() {

	override suspend fun execute(params: Bookmark) {
		return bookmarkRepository.insertBookmark(params)
	}
}