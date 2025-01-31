import kr.dagger.nuyhoostmdb.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

	override fun apply(target: Project) {
		with(target) {
			pluginManager.apply {
				apply("nuyhoos.android.library")
				apply("nuyhoos.android.hilt")
			}

			dependencies {
				add("implementation", project(":core:data"))
				add("implementation", project(":core:model"))
				add("implementation", project(":core:domain"))
				add("implementation", project(":core:ui"))
				add("implementation", project(":core:designsystem"))
				add("implementation", project(":core:utils"))
				add("implementation", project(":core:navigation"))

				add("implementation", libs.findLibrary("logger").get())
				add("implementation", libs.findLibrary("coil.kt").get())
				add("implementation", libs.findLibrary("coil.kt.compose").get())
				add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
				add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
				add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
				add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
			}
		}
	}
}