pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
	}
}

rootProject.name = "entry"

include("entry-core")
include("entry-persistence")
include("entry-presentation")
include("entry-infrastructure")
include("entry-common")
