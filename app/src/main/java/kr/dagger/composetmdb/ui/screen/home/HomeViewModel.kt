package kr.dagger.composetmdb.ui.screen.home

import android.util.Log
import android.util.LogPrinter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.cache
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.dagger.composetmdb.data.UiState
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.domain.model.Popular
import kr.dagger.composetmdb.domain.usecase.favorite.DeleteFavoriteMovieUseCase
import kr.dagger.composetmdb.domain.usecase.favorite.GetFavo
import kr.dagger.composetmdb.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kr.dagger.composetmdb.domain.usecase.movie.GetPopularMovieUseCase
import kr.dagger.composetmdb.domain.usecase.favorite.InsertFavoriteMovieUseCase
import kr.dagger.composetmdb.domain.usecase.movie.GetPopularMoviePagingUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private val getPopularMovieUseCase: GetPopularMovieUseCase,
	private val insertFavoriteMovieUseCase: InsertFavoriteMovieUseCase,
	private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase,
	private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
	private val getPopularMoviePagingUseCase: GetPopularMoviePagingUseCase,
	private val getFavo: GetFavo
) : ViewModel() {
	private val _uiStatePopularMovie: MutableStateFlow<UiState<MutableList<Popular>>> =
		MutableStateFlow(UiState.Loading)
	//	val popularPagingDataFlow: Flow<PagingData<Popular>> = getPopularMoviePagingUseCase.execute(Unit).cachedIn(viewModelScope)


	val popularPagingDataFlow: Flow<PagingData<Popular>> = getPopularMoviePagingUseCase.execute(Unit)
		.map { pagingData ->
			pagingData.map { popular ->
				if (popular.id in getFavorites().map { it.id }.toSet()) {
					popular.isFavorite = true
				}
				popular
			}.also {
				Logger.d("res :: $it")
			}
		}
		.cachedIn(viewModelScope)

//	private suspend fun getFavorites(): Flow<List<Favorite>> {
//		return withContext(Dispatchers.IO) {
//			getFavoriteMoviesUseCase.execute(Unit)
//		}
//	}


	private suspend fun getFavorites(): List<Favorite> {
		return withContext(Dispatchers.IO) {
			getFavo.execute(Unit)
		}
	}


//	private fun getPopularMovies(favorite: List<Favorite>) {
//		viewModelScope.launch {
//			getPopularMovieUseCase.execute(Unit).catch {
//				_uiStatePopularMovie.value = UiState.Error(it.message.toString())
//			}.collect { movie ->
//				_uiStatePopularMovie.value = if (favorite.isEmpty()) {
//					UiState.Success(movie.toMutableList())
//				} else {
//					val list = movie.map { popular ->
//						if (popular.id in favorite.map { it.id }.toSet()) {
//							popular.isFavorite = true
//						}
//						popular
//					}
//					UiState.Success(list.toMutableList())
//				}
//			}
//		}
//	}
//
//	fun getFavoriteMovies() {
//		viewModelScope.launch {
//			getFavoriteMoviesUseCase.execute(Unit).catch {
//				_uiStatePopularMovie.value = UiState.Error(it.message.toString())
//			}.collect {
//				getPopularMovies(it)
//			}
//		}
//	}

	fun insertFavoriteMovie(favorite: Favorite) {
		viewModelScope.launch {
			insertFavoriteMovieUseCase.execute(favorite)
		}
	}

	fun deleteFavoriteMovie(id: Long) {
		viewModelScope.launch {
			deleteFavoriteMovieUseCase.execute(id)
		}
	}
}