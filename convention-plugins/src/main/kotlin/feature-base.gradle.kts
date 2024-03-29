@file:Suppress("UnstableApiUsage")
import gradle.kotlin.dsl.accessors._75da82148b3d30221392f51f4dbc0b7f.implementation
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("kotlin-base")
    kotlin("plugin.serialization")
}

// https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.data.conversion)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.locations)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.metrics)
    implementation(libs.ktor.server.metrics.micrometer)
    implementation(libs.ktor.server.ssl)

    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.prometheus)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)

    implementation(libs.logback)

    implementation(libs.kotlinx.datetime)

    implementation(libs.quartz)


    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}

group = "com.mospolytech.features"
version = "com.mospolytech.features"
