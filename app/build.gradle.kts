plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "educa.iesam.examen.karamon.simpsons"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "educa.iesam.examen.karamon.simpsons"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    //Implementación de librerías y test unitario
    implementation(libs.gson)
    implementation(libs.serialization)
    testImplementation(libs.mockkag)
    testImplementation(libs.mockkand)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}