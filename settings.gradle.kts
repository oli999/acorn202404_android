pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "MyProject"
include(":app")
include(":Kotlin_study")
include(":step01layout")
include(":step02event")
include(":step02event2")
include(":step03listview")
include(":step04webview")
include(":step05httprequest")
include(":step05httprequest2")
include(":step06coroutine")
include(":step07customlistview")
include(":step07gallery")
include(":step08fragment")
