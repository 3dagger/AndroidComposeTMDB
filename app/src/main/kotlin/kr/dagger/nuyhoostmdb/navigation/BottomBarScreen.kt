package kr.dagger.nuyhoostmdb.navigation

import kr.dagger.nuyhoostmdb.R
import kr.dagger.nuyhoostmdb.core.designsystem.icon.NuyhoosIcons

sealed class BottomBarScreen(
	val route: String
) {
	data object Home: BottomBar(
		route = "home",
		label = R.string.home,
		icon = NuyhoosIcons.HomeOutline,
		selectedIcon = NuyhoosIcons.Home,
	)

	data object Bookmark: BottomBar(
		route = "bookmark",
		label = R.string.bookmark,
		icon = NuyhoosIcons.BookmarksBorder,
		selectedIcon = NuyhoosIcons.Bookmarks,
	)

	data object Search: BottomBar(
		route = "Search",
		label = R.string.search,
		icon = NuyhoosIcons.ImageSearchOutline,
		selectedIcon = NuyhoosIcons.ImageSearch,
	)

	data object Setting: BottomBar(
		route = "setting",
		label = R.string.setting,
		icon = NuyhoosIcons.SettingsOutline,
		selectedIcon = NuyhoosIcons.Settings,
	)
}