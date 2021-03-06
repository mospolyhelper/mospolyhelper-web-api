package com.mospolytech.domain.schedule.model.pack

import com.mospolytech.domain.peoples.model.Group
import com.mospolytech.domain.schedule.model.lesson_subject.LessonSubjectInfo
import com.mospolytech.domain.schedule.model.lesson_type.LessonTypeInfo
import com.mospolytech.domain.schedule.model.place.PlaceInfo
import com.mospolytech.domain.peoples.model.Teacher
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleInfo(
    val typesInfo: List<LessonTypeInfo>,
    val subjectsInfo: List<LessonSubjectInfo>,
    val teachersInfo: List<Teacher>,
    val groupsInfo: List<Group>,
    val placesInfo: List<PlaceInfo>
)