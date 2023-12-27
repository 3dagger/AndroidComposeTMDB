package kr.dagger.nuyhoostmdb.feature.favorite

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.dagger.nuyhoostmdb.core.model.Popular
import kr.dagger.nuyhoostmdb.core.ui.MainTemplate
import kr.dagger.nuyhoostmdb.core.ui.Progress

@Composable
fun FavoriteScreen(
	modifier: Modifier = Modifier,
	viewModel: FavoriteViewModel = hiltViewModel(),
	onAddFavoriteMovie: () -> Unit,
	onMovieClick: () -> Unit
) {
	MainTemplate(
		modifier = modifier,
		topBar = {},
		content = {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(MaterialTheme.colorScheme.background)
			) {
				viewModel.uiStateFavoriteMovieEntity.collectAsState(initial = FavoriteUiState.Loading).value.let { uiState ->
					when (uiState) {
						is FavoriteUiState.Loading -> {
							viewModel.getFavorites()
							Progress()
						}
						is FavoriteUiState.Success -> {
							when (uiState.data.isEmpty()) {
								true -> EmptyFavorite(modifier = modifier)
								false -> {
									FavoriteItemContent(
										movies = uiState.data.map {
											Popular(id = it.id, title = it.title, posterPath = it.posterPath, overView = it.overView)
										}.toMutableList(),
										viewModel = viewModel,
										navigateToDetail = {}
									)
								}
							}
						}
						is FavoriteUiState.Error -> {
							Text(
								text = uiState.errorMessage,
								color = Color.Black
							)
						}
					}
				}
			}
		}
	)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FavoriteItemContent(
	movies: MutableList<Popular>,
	viewModel: FavoriteViewModel,
	navigateToDetail: (Int) -> Unit
) {
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		LazyVerticalGrid(
			columns = GridCells.Adaptive(140.dp),
			content = {
				items(movies.size) {
					MovieCard(
						modifier = Modifier
							.fillMaxWidth()
							.animateItemPlacement(tween(durationMillis = 100)),
						popular = movies[it],
						navigateToDetail = navigateToDetail,
						isFavoriteScreen = true,
						favoriteClick = {_ ->
							viewModel.deleteFavoriteMovie(movies[it].id ?: 0L)
						}
					)
				}
			}, contentPadding = PaddingValues(8.dp)
		)
	}
}

@Composable
private fun EmptyFavorite(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Empty Favorite", style = MaterialTheme.typography.bodyMedium, color = Color.White)
	}
}