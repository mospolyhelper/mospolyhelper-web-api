package com.mospolytech.domain.services.payments

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaymentsApi(
    @SerialName("contracts")
    val contracts: List<ContractHeader>,
    @SerialName("selected")
    val selected: Contract?,
)
