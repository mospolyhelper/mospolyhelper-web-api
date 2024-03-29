rootProject.name = "mospolyhelper-web"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

includeBuild("convention-plugins")
include(":microservices")
include(":microservices:edugma")

include(":data")
include(":data:base")
include(":data:common")
include(":data:auth")
include(":data:schedule")
include(":data:peoples")
include(":data:services")

include(":domain")
include(":domain:base")
include(":domain:auth")
include(":domain:schedule")
include(":domain:peoples")
include(":domain:services")

include(":features")
include(":features:auth")
include(":features:base")
include(":features:schedule")
include(":features:peoples")
include(":features:services")
