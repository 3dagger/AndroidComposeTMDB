import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`kotlin-dsl`
}

group = "kr.dagger.composetmdb.buildlogic"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_17.toString()
	}
}

dependencies {
	compileOnly(libs.android.gradlePlugin)
	compileOnly(libs.android.tools.common)
	compileOnly(libs.kotlin.gradlePlugin)
	compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
	plugins {
		register("androidApplicationCompose") {
			id = "nuyhoos.android.application.compose"
			implementationClass = "AndroidApplicationComposeConventionPlugin"
		}
		register("androidApplication") {
			id = "nuyhoos.android.application"
			implementationClass = "AndroidApplicationConventionPlugin"
		}
		register("androidLibrary") {
			id = "nuyhoos.android.library"
			implementationClass = "AndroidLibraryConventionPlugin"
		}
		register("androidLibraryCompose") {
			id = "nuyhoos.android.library.compose"
			implementationClass = "AndroidLibraryComposeConventionPlugin"
		}
		register("androidHilt") {
			id = "nuyhoos.android.hilt"
			implementationClass = "AndroidHiltConventionPlugin"
		}
		register("androidFeature") {
			id = "nuyhoos.android.feature"
			implementationClass = "AndroidFeatureConventionPlugin"
		}
		register("androidRoom") {
			id = "nuyhoos.android.room"
			implementationClass = "AndroidRoomConventionPlugin"
		}
		register("jvmLibrary") {
			id = "nuyhoos.jvm.library"
			implementationClass = "JvmLibraryConventionPlugin"
		}
	}
}