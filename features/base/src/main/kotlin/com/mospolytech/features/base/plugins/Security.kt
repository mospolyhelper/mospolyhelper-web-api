package com.mospolytech.features.base.plugins

import com.mospolytech.features.base.AuthConfigs
import com.mospolytech.features.base.MpuPrincipal
import com.mospolytech.features.base.mpuAuth
import io.ktor.server.application.*
import io.ktor.server.auth.*

fun Application.configureSecurity() {
    val secret = environment.config.propertyOrNull("jwt.secret")?.getString().orEmpty()
    install(Authentication) {
        mpuAuth(AuthConfigs.MPU, secret) {
            validate {
                MpuPrincipal(it.payload.getClaim("mospolytechLkToken").asString())
            }
        }
    }
}
