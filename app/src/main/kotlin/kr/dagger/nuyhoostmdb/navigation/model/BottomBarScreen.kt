package kr.dagger.nuyhoostmdb.navigation.model

import kr.dagger.nuyhoostmdb.R

sealed class BottomBarScreen(
	val route: String
) {
	data object Home: BottomBar(
		route = "home",
		titleResId = R.string.home,
		icon = R.drawable.round_home_24,
		iconFocused = R.drawable.round_home_24
	)

	data object Favorite: BottomBar(
		route = "favorite",
		titleResId = R.string.favorite,
		icon = R.drawable.round_favorite_24,
		iconFocused = R.drawable.round_favorite_24
	)

	data object Search: BottomBar(
		route = "Search",
		titleResId = R.string.search,
		icon = R.drawable.round_search_24,
		iconFocused = R.drawable.round_search_24
	)

	data object Setting: BottomBar(
		route = "setting",
		titleResId = R.string.setting,
		icon = R.drawable.round_settings_24,
		iconFocused = R.drawable.round_settings_24
	)
}