package kr.dagger.nuyhoostmdb.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.dagger.nuyhoostmdb.core.model.Bookmark


interface BookmarkRepository {

	fun getBookmarks(): Flow<List<Bookmark>>

	suspend fun insertBookmark(bookmarkEntity: Bookmark)

	suspend fun deleteBookmark(id: Long)
}