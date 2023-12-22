package kr.dagger.composetmdb.ui.screen.home

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kr.dagger.composetmdb.data.UiState
import kr.dagger.composetmdb.data.local.Favorite
import kr.dagger.composetmdb.domain.model.Popular
import kr.dagger.composetmdb.ui.component.MovieItemContent
import kr.dagger.composetmdb.ui.component.Progress
import kr.dagger.composetmdb.ui.templete.MainTemplate

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	viewModel: HomeViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	Log.d("leeam", "homeScreen in")
	MainTemplate(
		modifier = modifier,
		topBar = {
//			TopAppBar(
//				backgroundColor = MaterialTheme.colors.primary,
//				contentColor = MaterialTheme.colors.primary,
//				elevation = 0.dp
//			) {
//				Text(
//					text = "TMDB",
//					style = MaterialTheme.typography.bodyMedium,
//					color = Color.White,
//					textAlign = TextAlign.Center,
//					maxLines = 1,
//					overflow = TextOverflow.Ellipsis,
//					modifier = Modifier
//						.weight(1F)
//						.align(Alignment.CenterVertically)
//				)
//			}
		},
		content = {
			Box(
//				modifier = Modifier
//					.fillMaxSize()
//					.background(MaterialTheme.colors.primary)
				modifier = Modifier
					.fillMaxSize()
					.background(MaterialTheme.colorScheme.primary)
			) {
				viewModel.popularPagingDataFlow.collectAsLazyPagingItems().let {
					when (it.loadState.refresh) {
						is LoadState.Loading -> {
							Progress()
						}
						is LoadState.Error -> {
							val message = (it.loadState.refresh as? LoadState.Error)?.error?.message ?: return@let
							Text(text = message, color = Color.White)
						}
						else -> {
							MovieItemContent(movies = it, viewModel = viewModel, navigateToDetail = navigateToDetail)
						}
					}
				}
			}
		}
	)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieItemContent(
	movies: LazyPagingItems<Popular>,
	viewModel: HomeViewModel,
	navigateToDetail: (Int) -> Unit
) {
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		LazyVerticalGrid(
			columns = GridCells.Adaptive(140.dp),
			content = {
				items(movies.itemCount) {
					MovieItemContent(
						modifier = Modifier
							.fillMaxWidth()
							.animateItemPlacement(tween(durationMillis = 100)),
						popular = movies[it] ?: Popular(id = 0, title = "", posterPath = "", overView = ""),
						navigateToDetail = navigateToDetail,
						isFavoriteScreen = false,
						favoriteClick = { flag ->
							when (flag) {
								true -> {
									Log.d("leeam", " in?")
									viewModel.insertFavoriteMovie(
										Favorite(
											id = movies[it]?.id ?: 0L,
											title = movies[it]?.title ?: "",
											posterPath = movies[it]?.posterPath ?: "",
											overView = movies[it]?.overView ?: ""
										)
									)
								}
								false -> {
									viewModel.deleteFavoriteMovie(movies[it]?.id ?: 0L)
								}
							}
						}
					)
				}
			}, contentPadding = PaddingValues(8.dp)
		)
	}
}

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun MovieItemContent(
//	movies: LazyPagingItems<Popular>,
//	viewModel: HomeViewModel,
//	navigateToDetail: (Int) -> Unit
//) {
//	Column(
//		modifier = Modifier.fillMaxSize()
//	) {
//		LazyVerticalGrid(
//			columns = GridCells.Adaptive(140.dp),
//			content = {
//				items(movies.itemCount) {
//					MovieItemContent(
//						modifier = Modifier
//							.fillMaxWidth()
//							.animateItemPlacement(tween(durationMillis = 100)),
//						popular = movies[it] ?: Popular(id = 0, title = "", posterPath = "", overView = ""),
//						navigateToDetail = navigateToDetail,
//						isFavoriteScreen = false,
//						favoriteClick = { flag ->
//							when (flag) {
//								true -> {
//									viewModel.insertFavoriteMovie(
//										Favorite(
//											id = movies[it]?.id ?: 0L,
//											title = movies[it]?.title ?: "",
//											posterPath = movies[it]?.posterPath ?: "",
//											overView = movies[it]?.overView ?: ""
//										)
//									)
//								}
//								false -> { viewModel.deleteFavoriteMovie(movies[it]?.id ?: 0L) }
//							}
//						}
//					)
//				}
//			}, contentPadding = PaddingValues(8.dp)
//		)
//	}
//}

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun MovieItemContent(
//	movies: MutableList<Popular>,
//	viewModel: HomeViewModel,
//	navigateToDetail: (Int) -> Unit
//) {
//	Column(
//		modifier = Modifier.fillMaxSize()
//	) {
//		LazyVerticalGrid(
//			columns = GridCells.Adaptive(140.dp),
//			content = {
//				items(movies.size) {
//					MovieItem(
//						modifier = Modifier
//							.fillMaxWidth()
//							.animateItemPlacement(tween(durationMillis = 100)),
//						movie = movies[it],
//						navigateToDetail = navigateToDetail,
//						isFavoriteScreen = false,
//						favoriteClick = { flag ->
//							when (flag) {
//								true -> {
//									viewModel.insertFavoriteMovie(
//										Favorite(
//											id = movies[it].id ?: 0L,
//											title = movies[it].title ?: "",
//											posterPath = movies[it].posterPath ?: "",
//											overView = movies[it].overView ?: ""
//										)
//									)
//								}
//								false -> {
//									viewModel.deleteFavoriteMovie(movies[it].id ?: 0L)
//								}
//							}
//						}
//					)
//				}
//			}, contentPadding = PaddingValues(8.dp)
//		)
//	}
//}