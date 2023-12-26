package kr.dagger.nuyhoostmdb.core.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
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
import kr.dagger.nuyhoostmdb.core.designsystem.theme.nuyhoostmdbTheme

@Composable
fun Progress() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.surface),
		verticalArrangement = Arrangement.Center
	) {
		CircularProgressIndicator(
			modifier = Modifier
				.fillMaxWidth()
				.wrapContentWidth(Alignment.CenterHorizontally),
			color = MaterialTheme.colorScheme.onBackground
		)
		Spacer(
			modifier = Modifier
				.size(32.dp)
				.wrapContentWidth(Alignment.CenterHorizontally),
		)
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.wrapContentWidth(Alignment.CenterHorizontally),
			text = "로드 중...",
			color = MaterialTheme.colorScheme.onBackground
		)
	}
}

@Preview(uiMode = UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews

@ThemePreviews
@Composable
fun ProgressPreview() {
	nuyhoostmdbTheme {
		Progress()
	}
}