package com.mospolytech.data.peoples.model.entity

import com.mospolytech.data.peoples.model.db.*
import com.mospolytech.data.peoples.model.db.StudentsDb.nullable
import com.mospolytech.data.peoples.model.entity.StudentEntity.Companion.referrersOn
import com.mospolytech.domain.peoples.model.Student
import com.mospolytech.domain.peoples.model.StudentShort
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class StudentEntity(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, StudentEntity>(StudentsDb)

    var firstName by StudentsDb.firstName
    var lastName by StudentsDb.lastName
    var middleName by StudentsDb.middleName

    var sex by StudentsDb.sex
    var birthday by StudentsDb.birthday
    var avatar by StudentsDb.avatar
    var group by GroupEntity optionalReferencedOn StudentsDb.group
    var specialization by StudentSpecializationEntity optionalReferencedOn StudentsDb.specialization
    var educationType by StudentsDb.educationType
    var educationForm by StudentsDb.educationForm
    var payment by StudentsDb.payment
    var course by StudentsDb.course
    var years by StudentsDb.years
    var code by StudentsDb.code
    var dormitory by StudentsDb.dormitory
    var dormitoryRoom by StudentsDb.dormitoryRoom
    var branch by StudentBranchEntity referencedOn StudentsDb.branch


    fun toModel(): Student {
        return Student(
            id = id.value,
            firstName = firstName,
            lastName = lastName,
            middleName = middleName,
            sex = sex,
            avatar = avatar,
            birthday = birthday,
            specialization = specialization?.toModel(),
            educationType = educationType,
            educationForm = educationForm,
            payment = payment,
            course = course,
            group = group?.toModel(),
            years = years,
            code = code,
            dormitory = dormitory,
            dormitoryRoom = dormitoryRoom,
            branch = branch.toModel()
        )
    }

    private fun fullName(): String {
        return buildString {
            append(lastName)
            append(" ")
            append(firstName)
            middleName?.let {
                append(" ")
                append(middleName)
            }
        }
    }
}