package kr.dagger.nuyhoostmdb.core.designsystem.component

import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTheme
import kr.dagger.nuyhoostmdb.core.designsystem.theme.ThemePreviews

@Composable
fun NuyhoosIconToggleButton(
	isChecked: Boolean,
	onCheckedChange: (Boolean) -> Unit,
	modifier: Modifier = Modifier,
	isEnabled: Boolean = true,
	icon: @Composable () -> Unit,
	checkedIcon: @Composable () -> Unit = icon
) {
	FilledIconToggleButton(
		checked = isChecked,
		onCheckedChange = onCheckedChange,
		modifier = modifier,
		enabled = isEnabled,
		colors = IconButtonDefaults.iconToggleButtonColors(
			checkedContainerColor = MaterialTheme.colorScheme.primaryContainer,
			checkedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
			disabledContainerColor = if (isChecked) {
				MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3F)
			} else {
				Color.Transparent
			}
		)
	) {
		if (isChecked) checkedIcon() else icon()
	}
}

@ThemePreviews
@Composable
fun FavoriteIconButtonPreview() {
	NuyhoosTheme {
		NuyhoosIconToggleButton(
			isChecked = true,
			onCheckedChange = { },
			icon = {
				Icon(
					imageVector = NuyhoosIcons.FavoriteBorder,
					contentDescription = null
				)
			},
			checkedIcon = {
				Icon(
					imageVector = NuyhoosIcons.Favorite,
					contentDescription = null
				)
			},
		)
	}
}

@ThemePreviews
@Composable
fun FavoriteIconButtonUncheckedPreview() {
	NuyhoosTheme {
		NuyhoosIconToggleButton(
			isChecked = false,
			onCheckedChange = { },
			icon = {
				Icon(
					imageVector = NuyhoosIcons.FavoriteBorder,
					contentDescription = null
				)
			},
			checkedIcon = {
				Icon(
					imageVector = NuyhoosIcons.Favorite,
					contentDescription = null
				)
			},
		)
	}
}