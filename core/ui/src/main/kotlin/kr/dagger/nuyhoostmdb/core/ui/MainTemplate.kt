package kr.dagger.nuyhoostmdb.core.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainTemplate(
	modifier: Modifier = Modifier,
	topBar: @Composable () -> Unit = {},
	bottomBar: @Composable () -> Unit = {},
	content: @Composable (PaddingValues) -> Unit
) {
	Scaffold(
		topBar = { topBar() },
		bottomBar = { bottomBar() },
		containerColor = Color.Transparent,
		contentColor = MaterialTheme.colorScheme.onBackground,
	) { innerPadding ->
		Surface(
			modifier = modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			content(innerPadding)
		}
	}
}