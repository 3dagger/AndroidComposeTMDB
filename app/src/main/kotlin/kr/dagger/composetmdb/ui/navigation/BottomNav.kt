package kr.dagger.composetmdb.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.dagger.composetmdb.ui.navigation.model.BottomBarScreen

@Composable
fun BottomNav(
	modifier: Modifier = Modifier,
	navController: NavHostController = rememberNavController()
) {
	val navBackStackEntry by navController.currentBackStackEntryAsState()
	val currentRoute = navBackStackEntry?.destination?.route

	Scaffold(
		modifier = Modifier,
		containerColor = Color.Black,
		contentColor = Color.Black,
//		backgroundColor = MaterialTheme.colors.primary,
		bottomBar = {
			if (currentRoute == BottomBarScreen.Home.route ||
				currentRoute == BottomBarScreen.Favorite.route ||
				currentRoute == BottomBarScreen.Search.route ||
				currentRoute == BottomBarScreen.Setting.route
			) {
				BottomBar(navController)
			}
		}
	) {
		MainNavHost(navController = navController, innerPadding = it)
	}
}

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
			.padding(start = 0.dp, end = 0.dp, top = 10.dp, bottom = 10.dp)
			.background(Color.Transparent)
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceEvenly,
		verticalAlignment = Alignment.CenterVertically
	) {
		screens.forEach { screen ->
			BottomNavItem(
				screen = screen,
				currentDestination = currentDestination,
				navController = navController
			)
		}
	}
}