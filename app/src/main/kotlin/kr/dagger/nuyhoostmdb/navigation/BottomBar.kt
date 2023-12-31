package kr.dagger.nuyhoostmdb.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
	val route: String,
	val icon: ImageVector,
	val selectedIcon: ImageVector,
	@StringRes val label: Int,
)