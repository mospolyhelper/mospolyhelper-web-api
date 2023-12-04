package com.mospolytech.domain.peoples.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String?,
    @SerialName("avatar")
    val avatar: String?,
)
