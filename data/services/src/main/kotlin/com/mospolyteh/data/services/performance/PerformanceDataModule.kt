package com.mospolyteh.data.services.performance

import com.mospolytech.domain.services.performance.PerformanceRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val performanceDataModule =
    module {
        singleOf(::PerformanceRepositoryImpl) { bind<PerformanceRepository>() }
        single { PerformanceService(get()) }
    }
