package kr.dagger.composetmdb.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Progress() {
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center
	) {
		CircularProgressIndicator(
			modifier = Modifier
				.fillMaxWidth()
				.wrapContentWidth(Alignment.CenterHorizontally)
		)
		Spacer(modifier = Modifier.size(32.dp))
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.wrapContentWidth(Alignment.CenterHorizontally),
			text = "로드 중...",
			color = MaterialTheme.colorScheme.onSurface
		)
	}
}

@Preview(showBackground = true)
@Composable
fun ProgressPreview() {
	Progress()
}
