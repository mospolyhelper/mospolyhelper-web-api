package com.mospolytech.features.peoples

import com.mospolytech.features.base.JobSchedulerManager
import org.quartz.CronScheduleBuilder
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.JobKey
import org.quartz.Trigger
import org.quartz.TriggerBuilder

class TeachersJobLauncher(
    private val jobSchedulerManager: JobSchedulerManager,
) {
    fun launch() {
        val triggerId = "UpdateTeachersJob"

        // If a job exists, delete it!
        val jobScheduler = jobSchedulerManager.scheduler
        val jobKey = JobKey.jobKey(TeachersUpdateJob.KEY, TeachersUpdateJob.GROUP)
        jobScheduler.deleteJob(jobKey)

        val job: JobDetail =
            JobBuilder.newJob(TeachersUpdateJob::class.java)
                .withIdentity(TeachersUpdateJob.KEY, TeachersUpdateJob.GROUP)
                .build()

        val trigger: Trigger =
            TriggerBuilder.newTrigger()
                .withIdentity(triggerId, TeachersUpdateJob.GROUP)
                .withSchedule(
                    CronScheduleBuilder.monthlyOnDayAndHourAndMinute(5, 1, 44),
                )
                .build()

        // Tell quartz to schedule the job using our trigger
        jobSchedulerManager.scheduler.scheduleJob(job, trigger)
    }

    fun launchNow() {
        val jobScheduler = jobSchedulerManager.scheduler
        val jobKey = JobKey.jobKey(TeachersUpdateJob.KEY, TeachersUpdateJob.GROUP)
        jobScheduler.triggerJob(jobKey)
    }
}
