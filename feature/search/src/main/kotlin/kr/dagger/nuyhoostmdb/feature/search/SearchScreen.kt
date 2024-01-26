package kr.dagger.nuyhoostmdb.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.dagger.nuyhoostmdb.core.ui.MainTemplate

@Composable
fun SearchScreen(
	modifier: Modifier = Modifier,
	viewModel: SearchViewModel = hiltViewModel(),
	navigateToDetail: (Int) -> Unit,
) {
	Box(
		modifier = modifier.fillMaxSize()
	) {
		LazyRowDemo()
	}
}

@Composable
fun LazyRowDemo() {
	val list = listOf(
		"A", "B", "C", "D"
	) + ((0..100).map { it.toString() })
	LazyRow(modifier = Modifier.fillMaxHeight()) {
		items(count = list.size, itemContent = { idx ->
			when (val item = list[idx]) {
				"A" -> {
					Text(text = item, style = TextStyle(fontSize = 80.sp))
				}
				"B" -> {
					Button(onClick = {}) {
						Text(text = item, style = TextStyle(fontSize = 80.sp))
					}
				}
				"C" -> {
					//Do Nothing
				}
				"D" -> {
					Text(text = item)
				}
				else -> {
					Text(text = item, style = TextStyle(fontSize = 80.sp))
				}
			}
		})
	}
}