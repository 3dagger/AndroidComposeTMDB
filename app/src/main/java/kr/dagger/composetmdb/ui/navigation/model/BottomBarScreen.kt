package kr.dagger.composetmdb.ui.navigation.model

import kr.dagger.composetmdb.R

sealed class BottomBarScreen(
	val route: String
) {
	object Home: BottomBar(
		route = "home",
		titleResId = R.string.home,
		icon = R.drawable.round_home_24,
		iconFocused = R.drawable.round_home_24
	)

	object Favorite: BottomBar(
		route = "favorite",
		titleResId = R.string.favorite,
		icon = R.drawable.round_favorite_24,
		iconFocused = R.drawable.round_favorite_24
	)

	object Search: BottomBar(
		route = "Search",
		titleResId = R.string.search,
		icon = R.drawable.round_search_24,
		iconFocused = R.drawable.round_search_24
	)

	object Setting: BottomBar(
		route = "setting",
		titleResId = R.string.setting,
		icon = R.drawable.round_settings_24,
		iconFocused = R.drawable.round_settings_24
	)
}