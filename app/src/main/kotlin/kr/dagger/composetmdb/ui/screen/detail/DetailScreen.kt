package kr.dagger.composetmdb.ui.screen.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.dagger.composetmdb.data.UiState
import kr.dagger.composetmdb.ui.component.Progress
import kr.dagger.composetmdb.ui.theme.Gray200

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
	id: Int,
	viewModel: DetailViewModel = hiltViewModel(),
	navigateBack: () -> Unit
) {
	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					Text(text = "상세", color = MaterialTheme.colorScheme.onPrimary)
				},
				navigationIcon = {
					IconButton(onClick = { navigateBack() }) {
						Icon(Icons.Filled.ArrowBack, "Back Icon", tint = Color.White)
					}
				},
//				backgroundColor = MaterialTheme.colors.primary,
//				contentColor = Color.White,
//				elevation = 0.dp
			)
		}, content = {
			Box(
				contentAlignment = Alignment.Center,
				modifier = Modifier
					.fillMaxSize()
					.background(Gray200)
					.padding(it)
			) {
				viewModel.uiStateDetailMovie.collectAsState(initial = UiState.Loading).value.let { uiState ->
					when (uiState) {
						is UiState.Loading -> {
							Log.d("leeam", "??")
							viewModel.getMovieDetail(id = id)
							Progress()
						}

						is UiState.Success -> {
							Log.d("leeam", "success :: ${uiState.data}")
						}

						is UiState.Error -> {
							Log.d("leeam", "error :: ${uiState.errorMessage}")
						}
					}
				}
			}
		}
	)
}