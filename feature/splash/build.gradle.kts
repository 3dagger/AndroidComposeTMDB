plugins {
	alias(libs.plugins.nuyhoos.android.feature)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.feature.splash"
}

dependencies {
	implementation(libs.accompanist.systemuicontroller)
	implementation(libs.androidx.core.splashscreen)
}