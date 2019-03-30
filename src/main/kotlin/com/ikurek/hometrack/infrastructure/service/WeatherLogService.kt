package com.ikurek.hometrack.infrastructure.service

import com.ikurek.hometrack.domain.dto.WeatherLogDTO
import com.ikurek.hometrack.domain.entity.WeatherLog
import com.ikurek.hometrack.domain.exception.NotFoundException
import com.ikurek.hometrack.infrastructure.repository.WeatherLogRepository
import com.ikurek.hometrack.infrastructure.transformer.WeatherLogTransformer
import org.springframework.stereotype.Service

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

    fun addLog(weatherLogDTO: WeatherLogDTO): WeatherLogDTO {
        val weatherLog = weatherLogTransformer.fromDTO(weatherLogDTO)
        val newEntry = weatherLogRepository.save(weatherLog)

        return weatherLogTransformer.toDTO(newEntry)
    }

}