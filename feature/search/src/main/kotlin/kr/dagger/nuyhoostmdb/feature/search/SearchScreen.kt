package kr.dagger.nuyhoostmdb.feature.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.orhanobut.logger.Logger
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.model.Search
import kr.dagger.nuyhoostmdb.core.ui.ErrorMessage
import kr.dagger.nuyhoostmdb.core.ui.Progress

@Composable
fun SearchRoute(
	modifier: Modifier = Modifier,
	viewModel: SearchViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
	val searchResultUiState by viewModel.searchResultUiState.collectAsStateWithLifecycle()

	SearchScreen(
		modifier = modifier,
		searchResultUiState = searchResultUiState,
		navigateToDetail = navigateToDetail,
		searchQuery = searchQuery,
		onSearchQueryChanged = viewModel::onSearchQueryChanged
	)
}

@Composable
fun SearchScreen(
	modifier: Modifier = Modifier,
	searchResultUiState: SearchResultUiState,
	onSearchQueryChanged: (String) -> Unit,
	searchQuery: String,
	navigateToDetail: (Int) -> Unit,
) {
	Box(
		modifier = modifier.fillMaxSize()
	) {
		Column {
			SearchTextField(
				searchQuery = searchQuery,
				onSearchQueryChanged = onSearchQueryChanged
			)
			when (searchResultUiState) {
				is SearchResultUiState.Loading -> {
					Progress()
				}
				is SearchResultUiState.Empty -> {
					EmptySearches(modifier = modifier)
				}
				is SearchResultUiState.Fail -> {
					ErrorMessage(
						modifier = modifier,
						message = searchResultUiState.message
					)
				}
				is SearchResultUiState.Success -> {
					SearchContent(
						searchItems = searchResultUiState.data.result,
						navigateToDetail = navigateToDetail
					)
				}
			}
		}
	}
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SearchTextField(
	searchQuery: String,
	onSearchQueryChanged: (String) -> Unit,
) {
	val focusRequest = remember { FocusRequester() }
	val keyboardController = LocalSoftwareKeyboardController.current

	val onSearchTriggered = {
		keyboardController?.hide()
	}

	TextField(
		value = searchQuery,
		colors = TextFieldDefaults.colors(
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent,
			disabledIndicatorColor = Color.Transparent
		),
		leadingIcon = {
			Icon(
				imageVector = NuyhoosIcons.Search,
				contentDescription = null,
				tint = MaterialTheme.colorScheme.onSurface,
			)
		},
		shape = RoundedCornerShape(16.dp),
		onValueChange = {
			onSearchQueryChanged(it)
			Logger.d("value changed : $it")
		},
		singleLine = true,
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
			.focusRequester(focusRequest)
			.onKeyEvent {
				if (it.key == Key.Enter) {
					onSearchTriggered()
					true
				} else {
					false
				}
			}
		,
		maxLines = 1,
	)
}

@Composable
fun SearchContent(
	searchItems: List<Search.SearchItem>,
	navigateToDetail: (Int) -> Unit
) {
	val scrollableState = rememberLazyListState()
	LazyColumn(
		modifier = Modifier
			.padding(horizontal = 8.dp),
		contentPadding = PaddingValues(vertical = 16.dp),
		state = scrollableState
	) {
		searchItems.forEach { searchItem ->
			item(key = searchItem.id) {
				SearchItem(
					id = searchItem.id.toInt(),
					posterPath = searchItem.posterPath,
					title = searchItem.title,
					voteAverage = searchItem.voteAverage,
					onClick = navigateToDetail
				)
			}
		}
	}
}

@Composable
private fun EmptySearches(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(
			text = "Empty results.",
			style = MaterialTheme.typography.bodyMedium,
			fontSize = 25.sp
		)
	}
}