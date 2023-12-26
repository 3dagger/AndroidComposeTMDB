plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.hilt)
	id("kotlinx-serialization")
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.data"

	testOptions {
		unitTests {
			isIncludeAndroidResources = true
			isReturnDefaultValues = true
		}
	}
}

dependencies {
	implementation(projects.core.database)
	implementation(projects.core.network)
	implementation(projects.core.model)

	implementation(libs.kotlinx.coroutines.android)
	implementation(libs.androidx.paging.runtime)
	implementation(libs.androidx.paging.compose)
	implementation(libs.retrofit.core)
	implementation(libs.retrofit.gson)
}