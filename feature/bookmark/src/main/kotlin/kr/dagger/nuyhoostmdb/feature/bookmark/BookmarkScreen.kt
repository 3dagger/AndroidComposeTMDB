package kr.dagger.nuyhoostmdb.feature.bookmark

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.dagger.nuyhoostmdb.core.model.Bookmark
import kr.dagger.nuyhoostmdb.core.ui.BookmarkCard
import kr.dagger.nuyhoostmdb.core.ui.Progress

@Composable
fun BookmarkRoute(
	modifier: Modifier = Modifier,
	viewModel: BookmarkViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	val bookmarkUiState by viewModel.bookmarkStateFlow.collectAsStateWithLifecycle()
	BookmarkScreen(
		bookmarkState = bookmarkUiState,
		navigateToDetail = navigateToDetail,
		modifier = modifier,
		onClickRemove = { viewModel.deleteFavoriteMovie(it) }
	)
}

@Composable
fun BookmarkScreen(
	modifier: Modifier = Modifier,
	bookmarkState: BookmarkUiState,
	onClickRemove: (Long) -> Unit,
	navigateToDetail: (Int) -> Unit,
) {
	Box(
		modifier = modifier.fillMaxSize()
	) {
		Column {
			when (bookmarkState) {
				BookmarkUiState.Loading -> Progress()
				is BookmarkUiState.Success -> {
					if (bookmarkState.bookmarks.isNotEmpty()) {
						BookmarkItemContent(
							items = bookmarkState.bookmarks,
							navigateToDetail = navigateToDetail,
							removeBookmark = onClickRemove
						)
					} else {
						EmptyBookmarks(modifier = modifier)
					}
				}

				is BookmarkUiState.Fail -> {
					Text(
						text = bookmarkState.errorMessage,
						color = Color.Black
					)
				}
			}
		}
	}
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BookmarkItemContent(
	items: List<Bookmark>,
	navigateToDetail: (Int) -> Unit,
	removeBookmark: (Long) -> Unit,
) {
	LazyVerticalGrid(
		modifier = Modifier
			.fillMaxSize(),
		columns = GridCells.Adaptive(140.dp),
		content = {
			items(items.size) {
				BookmarkCard(
					modifier = Modifier
						.fillMaxWidth()
						.animateItemPlacement(tween(durationMillis = 100)),
					bookmark = items[it],
					onClickRemove = removeBookmark,
					navigateToDetail = navigateToDetail,
				)
			}
		}, contentPadding = PaddingValues(8.dp)
	)
}

@Composable
private fun EmptyBookmarks(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(
			text = "Empty bookmarks.",
			style = MaterialTheme.typography.bodyMedium,
			fontSize = 25.sp
		)
	}
}