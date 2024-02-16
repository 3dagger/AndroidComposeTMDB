package kr.dagger.nuyhoostmdb.feature.search

import kr.dagger.nuyhoostmdb.core.model.Search

sealed interface SearchResultUiState {

	data object Loading : SearchResultUiState

	data object Empty : SearchResultUiState

	data class Fail(
		val message: String
	) : SearchResultUiState

	data class Success(
		val data: Search
	) : SearchResultUiState
}