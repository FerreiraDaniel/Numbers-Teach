pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }

}
rootProject.name = "ComposeForDesktop"

/*
include (":app")
include (":numbers")
include (":languages_dashboard")
include (":exercise_icons")
include (":commons")
*/
include(":ui_layer")
include(":audio_device_layer")
include(":data_layer")
include(":domain_layer")
include(":desktop_app")