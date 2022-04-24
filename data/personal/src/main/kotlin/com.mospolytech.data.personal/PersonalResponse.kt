package com.mospolytech.data.personal

import com.mospolytech.domain.personal.model.Personal
import com.mospolytech.domain.personal.model.Subdivision
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonalResponse(
    val user: User
) {
    @Serializable
    data class User(
        val id: Int,
        @SerialName("user_status")
        val userStatus: String,
        val status: String,
        val course: String,
        val name: String,
        val surname: String,
        val patronymic: String,
        val avatar: String,
        val birthday: String,
        val sex: String,
        val code: String,
        val faculty: String,
        val group: String,
        val specialty: String,
        val specialization: String,
        val degreeLength: String,
        val educationForm: String,
        val finance: String,
        val degreeLevel: String,
        val enterYear: String,
        val orders: List<String>,
        val subdivisions: List<Subdivision>? = null
    )

    @Serializable
    data class Subdivision(
        val categoty: String,
        val jobType: String? = null,
        val status: String? = null,
        val subdivision: String? = null,
        val wage: String? = null,
    )
}

fun PersonalResponse.toModel(): Personal {
    return Personal(
        id = this.user.id,
        userStatus = this.user.userStatus,
        status = this.user.status,
        course = this.user.course,
        name = this.user.name,
        surname = this.user.surname,
        patronymic = this.user.patronymic,
        avatar = this.user.avatar,
        birthday = this.user.birthday,
        sex = this.user.sex,
        code = this.user.code,
        faculty = this.user.faculty,
        group = this.user.group,
        specialty = this.user.specialty,
        specialization = this.user.specialization,
        degreeLength = this.user.degreeLength,
        educationForm = this.user.educationForm,
        finance = this.user.finance,
        degreeLevel = this.user.degreeLevel,
        enterYear = this.user.enterYear,
        orders = this.user.orders,
        subdivisions = this.user.subdivisions?.map { it.toModel() }
    )
}

fun PersonalResponse.Subdivision.toModel(): Subdivision {
    return Subdivision(
        category = this.categoty,
        jobType = this.jobType,
        status = this.status,
        subdivision = this.subdivision,
        wage = this.wage
    )
}