plugins {
	alias(libs.plugins.nuyhoos.android.feature)
	alias(libs.plugins.nuyhoos.android.library.compose)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.feature.favorite"
}

dependencies {
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.compose.material3)
	implementation(libs.androidx.compose.ui.tooling)
	implementation(libs.androidx.paging.compose)
	implementation(libs.androidx.paging.runtime)
}