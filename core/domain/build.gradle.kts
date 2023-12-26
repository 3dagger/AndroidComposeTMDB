plugins {
	alias(libs.plugins.nuyhoos.android.library)
	id("com.google.devtools.ksp")
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.domain"
}

dependencies {
	implementation(projects.core.data)
	implementation(projects.core.model)

	implementation(libs.hilt.android)
	implementation(libs.kotlinx.coroutines.android)
	implementation(libs.androidx.paging.runtime)
	ksp(libs.hilt.compiler)
}