import com.android.build.api.dsl.ApplicationExtension
import kr.dagger.nuyhoostmdb.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
class AndroidApplicationConventionPlugin : Plugin<Project> {

	override fun apply(target: Project) {
		with(target) {
			with(pluginManager) {
				apply("com.android.application")
				apply("org.jetbrains.kotlin.android")
			}

			extensions.configure<ApplicationExtension> {
				configureKotlinAndroid(this)

				defaultConfig {
					applicationId = "kr.dagger.nuyhoostmdb"
					targetSdk = 34
					versionCode = 1
					versionName = "1.0"

					testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
					vectorDrawables {
						useSupportLibrary = true
					}
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
		}
	}

}
