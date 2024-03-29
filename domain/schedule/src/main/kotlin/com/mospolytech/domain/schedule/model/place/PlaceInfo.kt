package com.mospolytech.domain.schedule.model.place

import com.mospolytech.domain.base.model.Coordinates
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class PlaceInfo : Comparable<PlaceInfo> {
    abstract val id: String
    abstract val title: String
    abstract val description: String?

    private fun getTypeNumber(): Int {
        return when (this) {
            is Building -> 0
            is Online -> 1
            is Other -> 2
        }
    }

    override fun compareTo(other: PlaceInfo): Int {
        val compareTypes = getTypeNumber().compareTo(other.getTypeNumber())
        if (compareTypes != 0) {
            return compareTypes
        } else {
            return title.compareTo(other.title)
        }
    }

    @Serializable
    @SerialName("building")
    data class Building(
        override val id: String,
        override val title: String,
        override val description: String?,
        val areaAlias: String? = null,
        val street: String? = null,
        val building: String? = null,
        val floor: String? = null,
        val auditorium: String? = null,
        val coordinates: Coordinates? = null,
    ) : PlaceInfo()

    @Serializable
    @SerialName("online")
    data class Online(
        override val id: String,
        override val title: String,
        override val description: String?,
        val url: String? = null,
    ) : PlaceInfo()

    @Serializable
    @SerialName("other")
    data class Other(
        override val id: String,
        override val title: String,
        override val description: String?,
    ) : PlaceInfo()
}
