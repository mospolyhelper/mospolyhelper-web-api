package com.mospolytech.microservices.schedule.plugins

import io.ktor.server.plugins.*
import io.micrometer.prometheus.*
import io.ktor.server.metrics.micrometer.*
import org.slf4j.event.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

//    val appMicrometerRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
//
//    install(MicrometerMetrics) {
//        registry = appMicrometerRegistry
//        // ...
//    }
//
//
//    routing {
//        get("/metrics-micrometer") {
//            call.respond(appMicrometerRegistry.scrape())
//        }
//    }
}