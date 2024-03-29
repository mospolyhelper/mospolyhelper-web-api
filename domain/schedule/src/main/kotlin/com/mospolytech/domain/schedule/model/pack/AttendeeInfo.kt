package com.mospolytech.domain.schedule.model.pack

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttendeeInfo(
    val id: String,
    val type: AttendeeType,
    val name: String,
    val description: String?,
    val avatar: String?,
)

@Serializable
enum class AttendeeType {
    @SerialName("teacher")
    Teacher,

    @SerialName("group")
    Group,

    ;

    fun createFullId(id: String): String {
        return this.name.lowercase() + "#" + id
    }
}
