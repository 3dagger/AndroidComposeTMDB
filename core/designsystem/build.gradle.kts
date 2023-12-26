plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.designsystem"
}

dependencies {
	api(platform(libs.androidx.compose.bom))
	api(libs.androidx.compose.material3)
	api(libs.androidx.compose.ui.tooling.preview)
	api(libs.androidx.compose.material.iconsExtended)

	debugApi(libs.androidx.ui.tooling)

	implementation(libs.androidx.core.ktx)
	implementation(libs.coil.kt.compose)
	implementation(libs.accompanist.systemuicontroller)
}