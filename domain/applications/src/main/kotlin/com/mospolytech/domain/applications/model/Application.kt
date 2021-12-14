package com.mospolytech.domain.applications.model
import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val creationDateTime: String,
    val number: String,
    val question: String,
    val status: String?,
    val statusDateTime: String?,
    val department: String?,
    val additionalInfo: String?
)