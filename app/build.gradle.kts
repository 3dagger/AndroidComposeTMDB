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
	namespace = "kr.dagger.nuyhoostmdb"

	defaultConfig {
		applicationId = "kr.dagger.nuyhoostmdb"
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
	implementation(projects.core.database)
	implementation(projects.core.model)
	implementation(projects.core.domain)
	implementation(projects.core.designsystem)
	implementation(projects.core.ui)

	implementation(projects.feature.home)
	implementation(projects.feature.bookmark)
	implementation(projects.feature.search)
	implementation(projects.feature.setting)
	implementation(projects.feature.movie)

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

	implementation(libs.accompanist.systemuicontroller)
	implementation(libs.logger)
}