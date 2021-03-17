plugins {
    kotlin("jvm")
}

group = "de.hshl.isd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation("de.hshl.isd:explicitarchitecture:0.1.0")
    implementation("de.hshl.isd:explicitarchitecture-posts-infrastructure-retrofit:0.0.2")
    implementation(project(":core"))
    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")

}
