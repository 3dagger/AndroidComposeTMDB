package kr.dagger.nuyhoostmdb.core.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons
import kr.dagger.nuyhoostmdb.core.designsystem.theme.NuyhoosTheme
import kr.dagger.nuyhoostmdb.core.designsystem.theme.ThemePreviews

@Composable
fun RowScope.NuyhoosNavigationBarItem(
	selected: Boolean,
	onClick: () -> Unit,
	icon: @Composable () -> Unit,
	modifier: Modifier = Modifier,
	selectedIcon: @Composable () -> Unit = icon,
	isEnabled: Boolean = true,
	label: @Composable (() -> Unit)? = null,
	isAlwaysShowLabel: Boolean = true,
) {
	NavigationBarItem(
		selected = selected,
		onClick = onClick,
		icon = if (selected) selectedIcon else icon,
		modifier = modifier,
		label = label,
		alwaysShowLabel = isAlwaysShowLabel,
		enabled = isEnabled,
		colors = NavigationBarItemDefaults.colors(
			selectedIconColor = NuyhoosNavigationDefaults.navigationSelectedItemColor(),
			unselectedIconColor = NuyhoosNavigationDefaults.navigationContentColor(),
			selectedTextColor = NuyhoosNavigationDefaults.navigationSelectedItemColor(),
			unselectedTextColor = NuyhoosNavigationDefaults.navigationContentColor(),
			indicatorColor = NuyhoosNavigationDefaults.navigationIndicatorColor(),
		),
	)
}

@Composable
fun NuyhoosNavigationBar(
	modifier: Modifier = Modifier,
	content: @Composable RowScope.() -> Unit,
) {
	NavigationBar(
		modifier = modifier,
		contentColor = NuyhoosNavigationDefaults.navigationContentColor(),
		tonalElevation = 0.dp,
		content = content
	)
}

@ThemePreviews
@Composable
fun NuyhoosNavigationPreview() {
	val items = listOf("Home", "Favorite", "Search", "Setting")
	val icons = listOf(
		NuyhoosIcons.HomeOutline,
		NuyhoosIcons.FavoriteBorder,
		NuyhoosIcons.ImageSearchOutline,
		NuyhoosIcons.SettingsOutline,
	)
	val selectedIcons = listOf(
		NuyhoosIcons.Home,
		NuyhoosIcons.Favorite,
		NuyhoosIcons.ImageSearch,
		NuyhoosIcons.Settings,
	)

	NuyhoosTheme {
		NuyhoosNavigationBar {
			items.forEachIndexed { index, item ->
				NuyhoosNavigationBarItem(
					label = { Text(item) },
					selected = index == 0,
					onClick = { },
					icon = {
						Icon(
							imageVector = icons[index],
							contentDescription = item,
						)
					},
					selectedIcon = {
						Icon(
							imageVector = selectedIcons[index],
							contentDescription = item,
						)
					}
				)
			}
		}
	}
}

object NuyhoosNavigationDefaults {
	@Composable
	fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

	@Composable
	fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

	@Composable
	fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}