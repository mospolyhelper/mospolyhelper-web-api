package com.mospolytech.features.schedule.routes

import com.mospolytech.domain.schedule.model.schedule_info.ScheduleInfoObject
import com.mospolytech.domain.schedule.repository.ScheduleInfoRepository
import com.mospolytech.features.base.utils.respondResult
import com.mospolytech.features.schedule.routes.model.ScheduleInfoRequest
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*

fun Routing.scheduleInfoRoutesV1(
    repository: ScheduleInfoRepository
) {
    route("/schedule") {
        route("/info") {
            get<ScheduleInfoRequest> {
                when (it.type) {
                    ScheduleInfoObject.Group -> call.respondResult(repository.getGroupInfo(it.key))
                    ScheduleInfoObject.Teacher -> call.respondResult(repository.getTeacher(it.key))
                    ScheduleInfoObject.Student -> call.respondResult(repository.getStudentInfo(it.key))
                    ScheduleInfoObject.Place -> call.respondResult(repository.getPlaceInfo(it.key))
                    ScheduleInfoObject.Subject -> call.respondResult(repository.getSubjectInfo(it.key))
                    ScheduleInfoObject.LessonType -> call.respondResult(repository.getLessonTypeInfo(it.key))
                }
            }
        }
        get("/subjects") {
            call.respondResult(repository.getAllSubjects())
        }
        get("/types") {
            call.respondResult(repository.getAllLessonTypes())
        }
        get("/teachers") {
            call.respondResult(repository.getAllTeachers())
        }
        get("/groups") {
            call.respondResult(repository.getAllGroups())
        }
        get("/places") {
            call.respondResult(repository.getAllPlaces())
        }
        get("/students") {
            call.respondResult(repository.getAllStudents())
        }
    }
}