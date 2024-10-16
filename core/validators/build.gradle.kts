plugins {
    alias(libs.plugins.android.library)
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-module-dependencies")
    id("test-module-dependencies")
    id("jacoco-module-dependencies")
}

android {
    namespace = "app.aaps.core.validators"
}


dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:interfaces"))
    implementation(project(":core:keys"))

    api(Libs.Dagger.android)
    api(Libs.Dagger.androidSupport)
    api(libs.com.google.android.material)

    kapt(Libs.Dagger.compiler)
    kapt(Libs.Dagger.androidProcessor)
}