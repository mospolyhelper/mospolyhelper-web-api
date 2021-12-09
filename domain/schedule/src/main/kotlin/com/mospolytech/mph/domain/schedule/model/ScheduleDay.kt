package com.mospolytech.mph.domain.schedule.model

import com.mospolytech.mph.domain.base.utils.converters.LocalDateConverter
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class ScheduleDay(
    @Serializable(with = LocalDateConverter::class)
    val date: LocalDate,
    val lessons: List<LessonsByTime>
)