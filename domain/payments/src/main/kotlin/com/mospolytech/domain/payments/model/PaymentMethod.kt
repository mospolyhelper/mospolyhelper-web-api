package com.mospolytech.domain.payments.model

import kotlinx.serialization.Serializable

@Serializable
data class PaymentMethod(
    val type: String,
    val title: String,
    val description: String,
    val url: String,
) {
    companion object {
        const val URL_TYPE = "url"
    }
}
