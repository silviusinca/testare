plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("io.kotest.multiplatform") version "5.0.2"
    id("jacoco")
}

android {
    namespace = "com.example.proiecttestare"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.proiecttestare"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.8.1")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.8.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("androidx.test:rules:1.5.0")
    testImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("androidx.test:core-ktx:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test.espresso:espresso-core")
    androidTestImplementation("androidx.test.ext:junit")
    testImplementation("org.mockito:mockito-core:5.11.0")
    androidTestImplementation("org.mockito:mockito-android:5.11.0")


}

jacoco {
    toolVersion = "0.8.11"
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy(tasks.withType<JacocoReport>()) // report is always generated after tests run
    extensions.configure(JacocoTaskExtension::class) {
//        destinationFile = layout.buildDirectory.file("jacoco/jacocoTest.exec").get().asFile
        classDumpDir = layout.buildDirectory.dir("jacoco/classpathdumps").get().asFile
    }

}
tasks.withType<JacocoReport> {
    dependsOn(tasks.withType<Test>()) // tests are required to run before generating the report
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}

android.testOptions {
    unitTests.all {
        it.useJUnitPlatform()
    }
}
