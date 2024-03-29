package com.mospolytech.domain.schedule.repository

import com.mospolytech.domain.base.model.PagingDTO
import com.mospolytech.domain.schedule.model.lessonSubject.LessonSubjectInfo

interface LessonSubjectsRepository {
    suspend fun get(id: String): LessonSubjectInfo?

    suspend fun getPaging(
        query: String,
        pageSize: Int,
        page: Int,
    ): PagingDTO<LessonSubjectInfo>
}
