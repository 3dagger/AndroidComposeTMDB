package kr.dagger.nuyhoostmdb.movie

sealed interface MovieUiState<out T : Any?> {

	data object Loading : MovieUiState<Nothing>

	data class Success<out T : Any>(val data: T) : MovieUiState<T>

	data class Error(val errorMessage: String) : MovieUiState<Nothing>
}