package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.dagger.nuyhoostmdb.core.database.dao.BookmarkDao
import kr.dagger.nuyhoostmdb.core.database.entity.BookmarkEntity
import kr.dagger.nuyhoostmdb.core.database.entity.asExternalModel
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
	private val bookmarkDao: BookmarkDao
) : BookmarkRepository {

	override fun getBookmarks(): Flow<List<Bookmark>> {
		return bookmarkDao.getBookmarks()
			.map {
				it.map(BookmarkEntity::asExternalModel)
			}
	}

	override suspend fun insertBookmark(bookmark: Bookmark) {
		return bookmarkDao.insertBookmark(
			bookmarkEntity = BookmarkEntity(
				id = bookmark.id,
				title = bookmark.title,
				posterPath = bookmark.posterPath,
				overView = bookmark.overView
			)
		)
	}

	override suspend fun deleteBookmark(id: Long) {
		return bookmarkDao.deleteBookmark(id = id)
	}
}