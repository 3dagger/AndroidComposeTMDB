package kr.dagger.nuyhoostmdb.navigation

sealed class GeneralScreen(
	val route: String
) {

	data object DetailMovie : GeneralScreen("home/{id}") {
		fun createRoute(id: Int) = "home/$id"
	}
}