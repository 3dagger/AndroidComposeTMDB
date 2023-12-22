import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
	alias(libs.plugins.nuyhoos.android.application)
	alias(libs.plugins.nuyhoos.android.application.compose)
	alias(libs.plugins.nuyhoos.android.hilt)
	alias(libs.plugins.nuyhoos.android.room)
}

fun getLocalProperties(propName: String): String {
	return gradleLocalProperties(rootDir).getProperty(propName)
}

android {
	namespace = "kr.dagger.composetmdb"

	defaultConfig {
		applicationId = "kr.dagger.composetmdb"
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
		buildConfigField("String", "TMDB_KEY", getLocalProperties("tmdb_key"))
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	buildFeatures {
		buildConfig = true
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
//	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//	implementation(platform("androidx.compose:compose-bom:2023.03.00"))
//	implementation("androidx.compose.ui:ui")
//	implementation("androidx.compose.ui:ui-graphics")
//	androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//	implementation("androidx.compose.material:material:1.3.1")
//	implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.compose.ui.tooling)

	implementation(libs.androidx.compose.material3)

	implementation(libs.androidx.navigation.compose)
	implementation(libs.androidx.hilt.navigation.compose)
	implementation(libs.androidx.paging.runtime)
	implementation(libs.androidx.paging.compose)

	implementation(libs.kotlinx.coroutines.android)
	implementation(libs.retrofit.core)
	implementation(libs.retrofit.gson)
	implementation(platform(libs.okhttp.bom))
	implementation(libs.okhttp.logging)

	implementation(libs.hilt.android)
	ksp(libs.hilt.compiler)

	implementation(libs.coil.kt)
	implementation(libs.coil.kt.compose)
	implementation(libs.coil.kt.svg)

//	implementation(libs.androidx.room.runtime)
//	implementation(libs.androidx.room.ktx)

//	implementation("androidx.core:core-ktx:1.9.0")
//	implementation("androidx.activity:activity-compose:1.7.0")
//	implementation("androidx.compose.ui:ui-tooling-preview")
//	implementation("androidx.compose.material3:material3")
//	testImplementation("junit:junit:4.13.2")
//	androidTestImplementation("androidx.test.ext:junit:1.1.5")
//	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//	androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//	debugImplementation("androidx.compose.ui:ui-tooling")
//	debugImplementation("androidx.compose.ui:ui-test-manifest")

//	 Coroutine
//	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")

//	 Retrofit
//	implementation("com.squareup.retrofit2:retrofit:2.9.0")
//	implementation("com.squareup.retrofit2:converter-gson:2.9.0")

//	 Okhttp3 BOM
//	implementation(platform("com.squareup.okhttp3:okhttp-bom:4.11.0"))
//	implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

//	 Hilt
//	implementation("com.google.dagger:hilt-android:2.46.1")
//	implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
//	kapt("com.google.dagger:hilt-android-compiler:2.46.1")

//	 Coil
//	implementation("io.coil-kt:coil-compose:2.2.2")
//
////	 Compose
//	implementation("androidx.navigation:navigation-compose:2.5.3")
//
//
////	 Room
//	kapt("androidx.room:room-compiler:2.4.3")
//	implementation("androidx.room:room-runtime:2.4.3")
//	implementation("androidx.room:room-ktx:2.4.3")
//
////	 Logger
//	implementation("com.orhanobut:logger:2.2.0")
//
////	 Paging
//	implementation("androidx.paging:paging-runtime:3.2.1")
//	implementation("androidx.paging:paging-compose:3.2.1")
}