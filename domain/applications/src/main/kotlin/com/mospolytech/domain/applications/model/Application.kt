package com.mospolytech.domain.applications.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val creationDateTime: LocalDateTime,
    val number: String,
    val question: String,
    val status: String?,
    val statusDateTime: LocalDateTime?,
    val department: String?,
    val additionalInfo: String?,
)
