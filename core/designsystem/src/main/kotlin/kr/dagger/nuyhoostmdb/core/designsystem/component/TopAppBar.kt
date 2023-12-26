package kr.dagger.nuyhoostmdb.core.designsystem.component

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.designsystem.theme.nuyhoostmdbTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuyhoosTopAppBAr(
	@StringRes titleRes: Int,
	navigationIcon: ImageVector,
	navigationIconContentDescription: String?,
	actionIcon: ImageVector,
	actionIconContentDescription: String?,
	modifier: Modifier = Modifier,
	colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
	onNavigationClick: () -> Unit = {},
	onActionClick: () -> Unit = {},
) {
	CenterAlignedTopAppBar(
		title = { Text(text = stringResource(id = titleRes)) },
		navigationIcon = {
			IconButton(onClick = onNavigationClick) {
				Icon(
					imageVector = navigationIcon,
					contentDescription = navigationIconContentDescription,
					tint = MaterialTheme.colorScheme.onSurface
				)
			}
		},
		actions = {
			IconButton(onClick = onActionClick) {
				Icon(
					imageVector = actionIcon,
					contentDescription = actionIconContentDescription,
					tint = MaterialTheme.colorScheme.onSurface
				)
			}
		},
		colors = colors,
		modifier = modifier
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
	uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme", showBackground = true
)
@Composable
fun NuyhoosAppBarDarkPreview() {
	nuyhoostmdbTheme {
		NuyhoosTopAppBAr(
			titleRes = android.R.string.untitled,
			navigationIcon = NuyhoosIcons.Search,
			navigationIconContentDescription = "Navigation icon",
			actionIcon = NuyhoosIcons.MoreVert,
			actionIconContentDescription = "Action icon",
		)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
	uiMode = UI_MODE_NIGHT_NO, name = "Light theme", showBackground = true
)
@Composable
fun NuyhoosAppBarLightPreview() {
	nuyhoostmdbTheme {
		NuyhoosTopAppBAr(
			titleRes = android.R.string.untitled,
			navigationIcon = NuyhoosIcons.Search,
			navigationIconContentDescription = "Navigation icon",
			actionIcon = NuyhoosIcons.MoreVert,
			actionIconContentDescription = "Action icon",
		)
	}
}