package com.mospolytech.data.common.db

import com.mospolytech.domain.base.AppConfig
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object MosPolyDb {
    // private val log = LoggerFactory.getLogger(this::class.java)

    fun connectAndMigrate(config: AppConfig) {
//        log.info("Initialising database")
//        val pool = hikari()
//        Database.connect(pool)
//        runFlyway(pool)

        Database.connect(
            url = config.url,
            driver = config.driver,
            user = config.login,
            password = config.password,
        )
    }

//    private fun hikari(): HikariDataSource {
//        val config = HikariConfig().apply {
//            driverClassName = "org.h2.Driver"
//            jdbcUrl = "jdbc:h2:mem:test"
//            maximumPoolSize = 3
//            isAutoCommit = false
//            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
//            validate()
//        }
//        return HikariDataSource(config)
//    }

//    private fun runFlyway(datasource: DataSource) {
//        val flyway = Flyway.configure()
//            .dataSource(datasource)
//            .load()
//        try {
//            flyway.info()
//            flyway.migrate()
//        } catch (e: Exception) {
//            log.error("Exception running flyway migration", e)
//            throw e
//        }
//        log.info("Flyway migration has finished")
//    }

    suspend fun <T> transaction(
        isLogEnabled: Boolean = false,
        block: suspend () -> T,
    ): T =
        newSuspendedTransaction(Dispatchers.IO) {
            if (isLogEnabled) {
                addLogger(StdOutSqlLogger)
            }
            block()
        }

    suspend fun <T> transactionCatching(block: suspend () -> T): Result<T> =
        kotlin.runCatching {
            newSuspendedTransaction(Dispatchers.IO) { block() }
        }
}
