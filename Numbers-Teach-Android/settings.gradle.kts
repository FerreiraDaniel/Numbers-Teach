pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }

}
rootProject.name = "Numbers Teach"

include (":app")
include (":numbers")
include (":languages_dashboard")
include (":exercise_icons")
include (":commons")
include(":domain_layer")
include(":interface_adapter")
include(":data_layer")
include(":desktop_ui_layer")
include(":desktop_audio_device_layer")
include(":desktop_app")
include(":android_ui_layer")
