package kr.dagger.nuyhoostmdb.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kr.dagger.nuyhoostmdb.navigation.model.BottomBarScreen

@Composable
fun BottomBar(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	val screens = listOf(
		BottomBarScreen.Home,
		BottomBarScreen.Favorite,
		BottomBarScreen.Search,
		BottomBarScreen.Setting
	)

	val navBackStackEntry by navController.currentBackStackEntryAsState()
	val currentDestination = navBackStackEntry?.destination

	Row(
		modifier = modifier
			.background(MaterialTheme.colorScheme.background)
			.padding(start = 0.dp, end = 0.dp, top = 10.dp, bottom = 10.dp)
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceEvenly,
		verticalAlignment = Alignment.CenterVertically
	) {
		screens.forEach { screen ->
			BottomNavigationItem(
				screen = screen,
				currentDestination = currentDestination,
				navController = navController
			)
		}
	}
}