package com.mospolytech.domain.perfomance.repository

import com.mospolytech.domain.perfomance.model.SemestersWithCourse
import com.mospolytech.domain.perfomance.model.Performance

interface PerformanceRepository {
    suspend fun getCourses(token: String): Result<List<Int>>
    suspend fun getSemesters(token: String): Result<List<Int>>

    suspend fun getCoursesWithSemesters(token: String): Result<SemestersWithCourse>

    suspend fun getPerformance(semester: String?, token: String): Result<List<Performance>>
}