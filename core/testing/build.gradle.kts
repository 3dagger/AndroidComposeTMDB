plugins {
	alias(libs.plugins.nuyhoos.android.library)
}

android {
	namespace = "kr.dagger.nuyhoostmdb.core.testing"
}

dependencies {
	api(kotlin("test"))
	api(libs.kotlinx.coroutines.test)
	api(projects.core.data)
	api(projects.core.model)

	api(libs.androidx.test.ext)
	api(libs.androidx.test.rules)
}