package com.ikurek.hometrack.infrastructure.repository

import com.ikurek.hometrack.domain.entity.WeatherLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.ZonedDateTime
import java.util.*

@Repository
interface WeatherLogRepository : JpaRepository<WeatherLog, Long> {

    @Query("SELECT log FROM WeatherLog log WHERE log.date = (SELECT MAX(log.date) FROM WeatherLog log)")
    fun tryGetLatestEntry(): Optional<WeatherLog>

    fun getAllByDateAfter(date: ZonedDateTime): List<WeatherLog>

    @Query("SELECT AVG(log.temperature) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetAverageTemperature(date: ZonedDateTime): Optional<Double>

    @Query("SELECT MAX(log.temperature) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetMaxTemperature(date: ZonedDateTime): Optional<Double>

    @Query("SELECT MIN(log.temperature) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetMinTemperature(date: ZonedDateTime): Optional<Double>

    @Query("SELECT AVG(log.humidity) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetAverageHumidity(date: ZonedDateTime): Optional<Double>

    @Query("SELECT MAX(log.humidity) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetMaxHumidity(date: ZonedDateTime): Optional<Double>

    @Query("SELECT MIN(log.humidity) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetMinHumidity(date: ZonedDateTime): Optional<Double>

    @Query("SELECT AVG(log.pressure) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetAveragePressure(date: ZonedDateTime): Optional<Double>

    @Query("SELECT MAX(log.pressure) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetMaxPressure(date: ZonedDateTime): Optional<Double>

    @Query("SELECT Min(log.pressure) FROM WeatherLog log WHERE log.date > ?1")
    fun tryGetMinPressure(date: ZonedDateTime): Optional<Double>
}