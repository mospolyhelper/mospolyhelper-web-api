package com.mospolytech.features.services.payments

import com.mospolytech.domain.services.payments.PaymentsRepository
import com.mospolytech.features.base.AuthConfigs
import com.mospolytech.features.base.utils.getTokenOrRespondError
import com.mospolytech.features.base.utils.respondResult
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.paymentsRoutesV1(repository: PaymentsRepository) {
    routing {
        authenticate(AuthConfigs.MPU, optional = true) {
            get("/payments") {
                val token = call.getTokenOrRespondError() ?: return@get
                call.respondResult(repository.getPayments(token))
            }
        }
    }
}