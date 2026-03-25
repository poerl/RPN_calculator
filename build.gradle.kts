plugins {
    kotlin("jvm") version "2.3.20"
    id("org.jlleitschuh.gradle.ktlint") version "14.2.0"
    id("org.jetbrains.kotlinx.kover") version "0.9.8"
    application
}

group = "io.github.poerl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
}

kotlin {
    jvmToolchain(25)
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

tasks.koverHtmlReport {
    dependsOn(tasks.test)
}

application {
    mainClass = "io.github.poerl.MainKt"
}
