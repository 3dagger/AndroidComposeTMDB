package kr.dagger.composetmdb.ui.navigation.model

sealed class GeneralScreen(
	val route: String
) {

	object DetailMovie : GeneralScreen("home/{id}") {
		fun createRoute(id: Int) = "home/$id"
	}
}