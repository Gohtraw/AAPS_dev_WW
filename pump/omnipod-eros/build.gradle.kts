plugins {
    alias(libs.plugins.android.library)
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-module-dependencies")
    id("test-module-dependencies")
    id("jacoco-module-dependencies")
}

android {
    namespace = "info.nightscout.androidaps.plugins.pump.omnipod.eros"

    defaultConfig {
        kapt {
            arguments {
                arg("room.incremental", "true")
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:interfaces"))
    implementation(project(":core:keys"))
    implementation(project(":core:libraries"))
    implementation(project(":core:utils"))
    implementation(project(":core:ui"))
    implementation(project(":core:validators"))
    implementation(project(":pump:omnipod-common"))
    implementation(project(":pump:pump-common"))
    implementation(project(":pump:rileylink"))

    api(Libs.AndroidX.Room.room)
    api(Libs.AndroidX.Room.runtime)
    api(Libs.AndroidX.Room.rxJava3)

    androidTestImplementation(project(":shared:tests"))
    // optional - Test helpers
    testImplementation(Libs.AndroidX.Room.testing)
    testImplementation(project(":implementation"))
    testImplementation(project(":shared:impl"))
    testImplementation(project(":shared:tests"))


    kapt(Libs.Dagger.compiler)
    kapt(Libs.Dagger.androidProcessor)
    kapt(Libs.AndroidX.Room.compiler)
}
