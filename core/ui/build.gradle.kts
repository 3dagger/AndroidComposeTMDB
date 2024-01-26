plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.ui"
}

dependencies {
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.compose.material3)
	implementation(libs.androidx.compose.ui.tooling)

	implementation(projects.core.designsystem)
	implementation(projects.core.domain)
	implementation(projects.core.model)
	implementation(projects.core.utils)

	implementation(libs.androidx.compose.material3)

	implementation(libs.coil.kt)
	implementation(libs.coil.kt.compose)
	implementation(libs.coil.kt.svg)
}