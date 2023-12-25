plugins {
	alias(libs.plugins.nuyhoos.android.feature)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.composetmdb.core.navigation"
}

dependencies {

	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.compose.ui.tooling)
	implementation(libs.androidx.compose.material3)

//	implementation(libs.androidx.core.ktx)
//	implementation(libs.appcompat)
//	implementation(libs.material)
//	testImplementation(libs.junit4)
//	androidTestImplementation(libs.junit)
//	androidTestImplementation(libs.androidx.test.espresso.core)
}