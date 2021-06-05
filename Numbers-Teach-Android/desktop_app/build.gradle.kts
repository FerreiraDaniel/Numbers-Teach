import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "0.3.1"
}

group = "me.ebtfed"
version = "1.0"

repositories {
    jcenter()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    implementation(project(":ui_layer"))
    implementation(project(":audio_device_layer"))
    implementation(project(":data_layer"))
    implementation(project(":domain_layer"))
    implementation(compose.desktop.currentOs)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "desktop_app"
            packageVersion = "1.0.0"
        }
    }
}