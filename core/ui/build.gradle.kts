plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.composetmdb.core.ui"
}

dependencies {
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.compose.material3)
	implementation(libs.androidx.compose.ui.tooling)
}