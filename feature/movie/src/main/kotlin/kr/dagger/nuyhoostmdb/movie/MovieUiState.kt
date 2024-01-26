package kr.dagger.nuyhoostmdb.movie

import kr.dagger.nuyhoostmdb.core.model.Detail

sealed interface MovieUiState {

	data object Loading: MovieUiState

	data class Fail(
		val errorMessage: String
	) : MovieUiState

	data class Success(
		val data: Detail
	) : MovieUiState
}