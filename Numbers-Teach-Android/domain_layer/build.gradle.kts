import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "me.ebtfed"
version = "1.0"

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["kotlin_coroutines_version"]}")
    implementation("org.junit.jupiter:junit-jupiter-api:${rootProject.extra["junit_version"]}")
    implementation("org.junit.jupiter:junit-jupiter-engine:${rootProject.extra["junit_version"]}")
    implementation("org.junit.jupiter:junit-jupiter-params:${rootProject.extra["junit_version"]}")
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${rootProject.extra["kotlin_coroutines_version"]}")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}