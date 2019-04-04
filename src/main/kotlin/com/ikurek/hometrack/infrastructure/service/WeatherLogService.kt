package com.ikurek.hometrack.infrastructure.service

import com.ikurek.hometrack.domain.dto.TodayDTO
import com.ikurek.hometrack.domain.dto.WeatherLogDTO
import com.ikurek.hometrack.domain.exception.CouldNotCalculateAverageException
import com.ikurek.hometrack.domain.exception.NotFoundException
import com.ikurek.hometrack.infrastructure.repository.WeatherLogRepository
import com.ikurek.hometrack.infrastructure.transformer.WeatherLogTransformer
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class WeatherLogService(
        val weatherLogRepository: WeatherLogRepository,
        val weatherLogTransformer: WeatherLogTransformer
) {

    fun getLatest(): WeatherLogDTO {
        val latestEntry = weatherLogRepository.tryGetLatestEntry()
                .orElseThrow { NotFoundException() }

        return weatherLogTransformer.toDTO(latestEntry)
    }

    fun getToday(): TodayDTO {
        val currentDate = ZonedDateTime.now()
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)

        val entries = weatherLogRepository.getAllByDateAfter(currentDate)

        val avgTemperature = weatherLogRepository.tryGetAverageTemperature(currentDate)
                .orElseThrow { CouldNotCalculateAverageException() }

        val avgHumidity = weatherLogRepository.tryGetAverageHumidity(currentDate)
                .orElseThrow { CouldNotCalculateAverageException() }

        val avgPressure = weatherLogRepository.tryGetAveragePressure(currentDate)
                .orElseThrow { CouldNotCalculateAverageException() }

        return TodayDTO(
                avgTemperature,
                avgHumidity,
                avgPressure,
                entries.map { weatherLogTransformer.toDTO(it) }
        )
    }

    fun addLog(weatherLogDTO: WeatherLogDTO): WeatherLogDTO {
        val weatherLog = weatherLogTransformer.fromDTO(weatherLogDTO)
        val newEntry = weatherLogRepository.save(weatherLog)

        return weatherLogTransformer.toDTO(newEntry)
    }

}