package kr.dagger.nuyhoostmdb.feature.bookmark

import kr.dagger.nuyhoostmdb.core.model.Bookmark

sealed interface BookmarkUiState {

	data object Loading : BookmarkUiState

	data class Fail(
		val errorMessage: String
	) : BookmarkUiState

	data class Success(
		val bookmarks: List<Bookmark>
	) : BookmarkUiState
}