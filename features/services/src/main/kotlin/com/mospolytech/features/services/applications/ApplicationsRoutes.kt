package com.mospolytech.features.services.applications

import com.mospolytech.domain.services.applications.ApplicationsRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.applicationsRoutesV1(repository: ApplicationsRepository) {
    routing {
        route("/applications") {
            get {
                call.respond(repository.getApplications())
            }
        }
    }
}
