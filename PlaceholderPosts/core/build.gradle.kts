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
    implementation("de.hshl.isd:explicitarchitecture:0.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")

}
