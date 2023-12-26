package kr.dagger.nuyhoostmdb.feature.home

sealed interface HomeUiState<out T : Any?> {

	data object Loading : HomeUiState<Nothing>

	data class Success<out T : Any>(val data: T) : HomeUiState<T>

	data class Error(val errorMessage: String) : HomeUiState<Nothing>
}