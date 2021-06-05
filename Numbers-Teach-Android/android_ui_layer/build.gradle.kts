plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = rootProject.extra["compile_sdk_version"] as Int
    buildToolsVersion = rootProject.extra["build_tools_version"] as String

    defaultConfig {
        minSdk = rootProject.extra["minimum_sdk_version"] as Int
        targetSdk = rootProject.extra["target_sdk_version"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        proguardFiles(
            "proguard-rules.pro"
        )
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = rootProject.extra["jvm_target"] as String
        useIR = true
    }

    buildFeatures {
        compose = true
        // Disable unused AGP features
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${rootProject.extra["core_version"]}")
    implementation("androidx.appcompat:appcompat:${rootProject.extra["appcompat_version"]}")
    implementation("com.google.android.material:material:${rootProject.extra["material_design_version"]}")
    // JetPack compose ui
    implementation("androidx.compose.ui:ui:${rootProject.extra["jetPackComposeVersion"]}")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["jetPackComposeVersion"]}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${rootProject.extra["jetPackComposeVersion"]}")
    // Material Design
    implementation("androidx.compose.material:material:${rootProject.extra["jetPackComposeVersion"]}")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:${rootProject.extra["jetPackComposeVersion"]}")
    implementation("androidx.compose.material:material-icons-extended:${rootProject.extra["jetPackComposeVersion"]}")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:${rootProject.extra["jetPackComposeVersion"]}")
    implementation("androidx.compose.runtime:runtime-rxjava2:${rootProject.extra["jetPackComposeVersion"]}")

    testImplementation("junit:junit:4.13.2")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["jetPackComposeVersion"]}")

    testImplementation("junit:junit:4.13.2")
}