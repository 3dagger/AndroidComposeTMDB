plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.hilt)
	alias(libs.plugins.nuyhoos.android.room)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.database"

	defaultConfig {
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
}

dependencies {
	implementation(projects.core.model)
	implementation(libs.kotlinx.coroutines.android)
}