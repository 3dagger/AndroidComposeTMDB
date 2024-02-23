plugins {
	alias(libs.plugins.nuyhoos.android.library)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.testing"
}

dependencies {
	api(kotlin("test"))
	api(libs.kotlinx.coroutines.test)

	api(libs.androidx.test.ext)
	api(libs.androidx.test.rules)
//	implementation(libs.androidx.test.ext)

//	implementation(libs.androidx.test.core)
}