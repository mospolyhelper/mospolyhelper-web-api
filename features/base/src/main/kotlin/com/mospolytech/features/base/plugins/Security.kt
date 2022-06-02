package com.mospolytech.features.base.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.mospolytech.features.base.AuthConfigs
import com.mospolytech.features.base.MpuPrincipal
import com.mospolytech.features.base.mpuAuth
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {
    install(Authentication) {
        mpuAuth(AuthConfigs.Mpu) {
            validate {
                MpuPrincipal(it.payload.getClaim("mospolytechLkToken").asString())
            }
        }
    }
}
