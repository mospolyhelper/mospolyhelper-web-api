package com.mospolytech.domain.services.applications

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
