package kr.dagger.nuyhoostmdb.core.designsystem.component

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTheme
import kr.dagger.nuyhoostmdb.core.designsystem.theme.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuyhoosTopAppBar(
	@StringRes titleRes: Int,
	actionIcon: ImageVector,
	actionIconContentDescription: String?,
	modifier: Modifier = Modifier,
	colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
	onActionClick: () -> Unit = {},
) {
	TopAppBar(
		title = { Text(text = stringResource(id = titleRes), fontWeight = FontWeight.Bold) },
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
@ThemePreviews
@Composable
fun NuyhoosTopAppBarPreview() {
	NuyhoosTheme {
		NuyhoosTopAppBar(
			titleRes = android.R.string.untitled,
			actionIcon = NuyhoosIcons.MoreVert,
			actionIconContentDescription = "Action icon",
		)
	}
}