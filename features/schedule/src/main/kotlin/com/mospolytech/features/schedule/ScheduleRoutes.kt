package com.mospolytech.features.schedule

import com.mospolytech.domain.personal.repository.PersonalRepository
import com.mospolytech.domain.schedule.model.source.ScheduleSources
import com.mospolytech.domain.schedule.repository.ScheduleRepository
import com.mospolytech.features.schedule.routes.freePlaceRoutesV1
import com.mospolytech.features.schedule.routes.lessonsRoutesV1
import com.mospolytech.features.schedule.routes.scheduleRoutesV1
import com.mospolytech.features.schedule.routes.sourcesRoutesV1
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*


fun Application.scheduleRoutes(
    repository: ScheduleRepository,
    personalRepository: PersonalRepository
) {
    routing {
        sourcesRoutesV1(repository)
        scheduleRoutesV1(repository, personalRepository)
        lessonsRoutesV1(repository)
        freePlaceRoutesV1(repository)
    }
}

@Location("/{type}/{key}")
data class ScheduleRequest(
    val type: ScheduleSources,
    val key: String
)

@Location("/{type}")
data class ScheduleSourceListRequest(
    val type: ScheduleSources
)