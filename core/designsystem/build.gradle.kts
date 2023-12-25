plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.composetmdb.core.designsystem"
}

dependencies {
	api(platform(libs.androidx.compose.bom))
	api(libs.androidx.compose.material3)
	api(libs.androidx.compose.ui.tooling.preview)

	implementation(libs.androidx.core.ktx)
	implementation(libs.coil.kt.compose)
	implementation(libs.accompanist.systemuicontroller)
}