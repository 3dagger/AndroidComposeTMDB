plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.navigation"
}

dependencies {
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.compose.ui.tooling)
	implementation(libs.androidx.compose.material3)
}