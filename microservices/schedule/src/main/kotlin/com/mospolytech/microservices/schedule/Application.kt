package com.mospolytech.microservices.schedule

import com.mospolytech.features.base.koin.get
import com.mospolytech.features.schedule.scheduleDataConversion
import com.mospolytech.features.schedule.scheduleRoutesV1
import com.mospolytech.microservices.schedule.plugins.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureSecurity()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureDi()
    setDataConversions()
    setRoutes()
}

fun Application.setRoutes() {
    scheduleRoutesV1(get())
}

fun Application.setDataConversions() {
    install(DataConversion) {
        scheduleDataConversion()
    }
}