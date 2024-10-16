plugins {
    alias(libs.plugins.android.library)
    id("kotlin-android")
    id("kotlin-kapt")
    kotlin("plugin.allopen")
    id("android-module-dependencies")
    id("test-module-dependencies")
    id("jacoco-module-dependencies")
}

android {
    namespace = "app.aaps.database.impl"

    defaultConfig {
        kapt {
            arguments {
                arg("room.incremental", "true")
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }
    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }
}

dependencies {
    api(Libs.Kotlin.stdlibJdk8)
    api(Libs.Kotlin.reflect)
    api(Libs.AndroidX.core)

    api(Libs.Rx.rxAndroid)
    api(Libs.Rx.rxKotlin)

    api(libs.com.google.code.gson)

    api(Libs.AndroidX.Room.room)
    api(Libs.AndroidX.Room.runtime)
    api(Libs.AndroidX.Room.rxJava3)

    api(Libs.Dagger.android)
    api(Libs.Dagger.androidSupport)

    androidTestImplementation(Libs.AndroidX.Room.testing)

    kapt(Libs.Dagger.compiler)
    kapt(Libs.AndroidX.Room.compiler)
}