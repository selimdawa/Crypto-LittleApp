plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.ksp.processor)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.littleapp.crypto"
    compileSdk {
       version = release(37)
    }

    defaultConfig {
        applicationId = "com.littleapp.crypto"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.preference.ktx)           //Shared Preference
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Layout
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    //Image
    implementation(libs.circleimageview)                //Circle image
    implementation(libs.coil.kt)    //Coil
    //Navigation
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    //Lifecycle
    //implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.livedata)
    //Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.coroutines.adapter)
    //Dagger - Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    //Other's
    implementation(libs.okhttp.core)     //OkHttp
    implementation(libs.okhttp.logging)     //OkHttp
    implementation(libs.google.gson)    //Gson
    implementation(libs.androidx.paging)     //Paging3
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.viewbinding.property.delegate)
    ksp(libs.kotlin.metadata.jvm)                       //Kotlin
}