plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.hilt)
//	id("kotlinx-serialization")
}

android {
	namespace = "kr.dagger.composetmdb.core.network"

	buildFeatures {
		buildConfig = true
	}
}

dependencies {
	implementation(projects.core.model)

	implementation(platform(libs.okhttp.bom))
	implementation(libs.okhttp.logging)
	implementation(libs.retrofit.core)
	implementation(libs.retrofit.gson)
}