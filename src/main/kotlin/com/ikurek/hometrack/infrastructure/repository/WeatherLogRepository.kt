package com.ikurek.hometrack.infrastructure.repository

import com.ikurek.hometrack.domain.entity.WeatherLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface WeatherLogRepository : JpaRepository<WeatherLog, Long> {

    @Query("SELECT weatherlog FROM WeatherLog weatherlog WHERE weatherlog.date = (max(weatherlog.date))")
    fun tryGetLatestEntry(): Optional<WeatherLog>
}