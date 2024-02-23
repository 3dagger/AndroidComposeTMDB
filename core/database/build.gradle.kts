plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.hilt)
	alias(libs.plugins.nuyhoos.android.room)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.database"

	defaultConfig {
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}

dependencies {
	implementation(projects.core.model)
	implementation(libs.kotlinx.coroutines.android)

	androidTestImplementation(projects.core.testing)
}