package kr.dagger.composetmdb

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
	commonExtension: CommonExtension<*, *, *, *, *>,
) {
	commonExtension.apply {
		buildFeatures {
			compose = true
		}

		composeOptions {
			kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
		}

		dependencies {
			val bom = libs.findLibrary("androidx-compose-bom").get()
			add("implementation", platform(bom))
			add("androidTestImplementation", platform(bom))
			add("debugImplementation", libs.findLibrary("androidx.compose.ui.testManifest").get())
		}

		testOptions {
			unitTests {
				// For Robolectric
				isIncludeAndroidResources = true
			}
		}
	}
}