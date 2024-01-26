pluginManagement {
	includeBuild("build-logic")
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "NuyhoosTMDB"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":feature")
include(":feature:bookmark")
include(":feature:home")
include(":feature:search")
include(":feature:setting")
include(":feature:movie")
include(":core")
include(":core:data")
include(":core:database")
include(":core:designsystem")
include(":core:domain")
include(":core:network")
include(":core:model")
include(":core:navigation")
include(":core:ui")
include(":core:utils")
