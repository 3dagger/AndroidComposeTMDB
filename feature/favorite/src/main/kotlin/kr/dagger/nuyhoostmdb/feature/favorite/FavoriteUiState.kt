package kr.dagger.nuyhoostmdb.feature.favorite

sealed interface FavoriteUiState<out T : Any?> {

	data object Loading : FavoriteUiState<Nothing>

	data class Success<out T : Any>(val data: T) : FavoriteUiState<T>

	data class Error(val errorMessage: String) : FavoriteUiState<Nothing>
}