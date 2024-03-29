package com.mospolytech.domain.schedule.model.source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleSource(
    @SerialName("id")
    val id: String,
    @SerialName("type")
    val type: ScheduleSourceTypes,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("avatar")
    val avatar: String?,
)
