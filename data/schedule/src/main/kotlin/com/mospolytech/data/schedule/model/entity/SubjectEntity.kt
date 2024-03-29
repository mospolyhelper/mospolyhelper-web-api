package com.mospolytech.data.schedule.model.entity

import com.mospolytech.data.schedule.model.db.SubjectsDb
import com.mospolytech.domain.schedule.model.lessonSubject.LessonSubjectInfo
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class SubjectEntity(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, SubjectEntity>(SubjectsDb)

    var title by SubjectsDb.title
    var type by SubjectsDb.type
    var description by SubjectsDb.description

    fun toModel(): LessonSubjectInfo {
        return LessonSubjectInfo(
            id = id.value,
            title = title,
            type = type,
            description = description,
        )
    }
}
