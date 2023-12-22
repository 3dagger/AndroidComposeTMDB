plugins {
	alias(libs.plugins.nuyhoos.android.library)
	alias(libs.plugins.nuyhoos.android.hilt)
	id("kotlinx-serialization")
}

android {
	namespace = "kr.dagger.composetmdb.core.data"

	testOptions {
		unitTests {
			isIncludeAndroidResources = true
			isReturnDefaultValues = true
		}
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(projects.core.database)

//	implementation(libs.androidx.core.ktx)
//	implementation(libs.appcompat)
//	implementation(libs.material)
//	testImplementation(libs.junit4)
//	androidTestImplementation(libs.junit)
//	androidTestImplementation(libs.androidx.test.espresso.core)
}