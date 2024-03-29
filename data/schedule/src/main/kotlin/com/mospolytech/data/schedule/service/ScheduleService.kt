package com.mospolytech.data.schedule.service

import com.mospolytech.data.schedule.model.response.ScheduleResponse
import com.mospolytech.data.schedule.model.response.ScheduleSessionResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ScheduleService(
    private val client: HttpClient,
) {
    companion object {
        private const val BASE_URL = "https://rasp.dmami.ru"

        private const val GET_SCHEDULE = "$BASE_URL/site/group"
        private const val GET_SCHEDULE_ALL = "$BASE_URL/semester.json"
        private const val GET_SCHEDULE_ALL_SESSION = "$BASE_URL/session-file.json"

        private const val BASE_URL_TEACHER = "https://kaf.dmami.ru"
        private const val GET_SCHEDULE_TEACHER = "$BASE_URL_TEACHER/lessons/teacher-html"
    }

    suspend fun getScheduleByGroup(
        groupTitle: String,
        isSession: Boolean,
    ): String {
        return client.get(GET_SCHEDULE) {
            header("referer", BASE_URL)
            // For json error status if schedule is not ready instead html
            header("X-Requested-With", "XMLHttpRequest")
            parameter("group", groupTitle)
            parameter("session", if (isSession) 1 else 0)
        }.body()
    }

    suspend fun getScheduleByTeacher(teacherId: String): String {
        return client.get(GET_SCHEDULE_TEACHER) {
            header("referer", BASE_URL_TEACHER)
            header("X-Requested-With", "XMLHttpRequest")
            parameter("id", teacherId)
        }.body()
    }

    suspend fun getSchedules(): ScheduleResponse {
        return client.get(GET_SCHEDULE_ALL) {
            header("referer", BASE_URL)
            // For json error status if schedule is not ready instead html
            header("X-Requested-With", "XMLHttpRequest")
        }.body()
    }

    suspend fun getSchedulesSession(): ScheduleSessionResponse {
        return client.get(GET_SCHEDULE_ALL_SESSION) {
            header("referer", BASE_URL)
            // For json error status if schedule is not ready instead html
            header("X-Requested-With", "XMLHttpRequest")
        }.body()
    }
}
