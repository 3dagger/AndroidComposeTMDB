plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.hilt)
	alias(libs.plugins.nuyhoos.android.room)
}

android {
	namespace = "kr.dagger.composetmdb.core.database"

	defaultConfig {
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}


//	compileOptions {
//		sourceCompatibility = JavaVersion.VERSION_1_8
//		targetCompatibility = JavaVersion.VERSION_1_8
//	}
//	kotlinOptions {
//		jvmTarget = "1.8"
//	}
}

dependencies {

	implementation(libs.kotlinx.coroutines.android)
//	implementation(libs.androidx.core.ktx)
//	implementation(libs.appcompat)
//	implementation(libs.material)
//	testImplementation(libs.junit4)
//	androidTestImplementation(libs.junit)
//	androidTestImplementation(libs.androidx.test.espresso.core)
}