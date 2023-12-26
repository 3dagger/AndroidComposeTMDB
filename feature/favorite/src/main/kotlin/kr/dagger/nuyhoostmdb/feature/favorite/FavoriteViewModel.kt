package kr.dagger.nuyhoostmdb.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.dagger.nuyhoostmdb.core.domain.usecase.favorite.DeleteFavoriteMovieUseCase
import kr.dagger.nuyhoostmdb.core.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kr.dagger.nuyhoostmdb.core.model.Favorite
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
	private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
	private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase
) : ViewModel() {
	private val _uiStateFavoriteMovieEntity: MutableStateFlow<FavoriteUiState<MutableList<Favorite>>> = MutableStateFlow(FavoriteUiState.Loading)
	val uiStateFavoriteMovieEntity: StateFlow<FavoriteUiState<MutableList<Favorite>>> = _uiStateFavoriteMovieEntity

	fun getFavorites() {
		viewModelScope.launch {
			getFavoriteMoviesUseCase.execute(Unit).catch {
				_uiStateFavoriteMovieEntity.value = FavoriteUiState.Error(it.message.toString())
			}.collect { favorite ->
				_uiStateFavoriteMovieEntity.value = FavoriteUiState.Success(favorite.toMutableList())
			}
		}
	}

	fun deleteFavoriteMovie(id: Long) {
		viewModelScope.launch {
			deleteFavoriteMovieUseCase.execute(id)
			getFavorites()
		}
	}
}