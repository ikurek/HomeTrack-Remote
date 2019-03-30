package com.ikurek.hometrack.infrastructure.transformer

import com.ikurek.hometrack.domain.`interface`.EntityTransformer
import com.ikurek.hometrack.domain.dto.WeatherLogDTO
import com.ikurek.hometrack.domain.entity.WeatherLog
import org.springframework.stereotype.Component

@Component
class WeatherLogTransformer : EntityTransformer<WeatherLog, WeatherLogDTO> {
    override fun toDTO(from: WeatherLog): WeatherLogDTO =
            WeatherLogDTO(
                    id = from.id,
                    temperature = from.temperature,
                    humidity = from.humidity,
                    pressure = from.pressure,
                    date = from.date
            )

    override fun fromDTO(to: WeatherLogDTO): WeatherLog =
            WeatherLog(
                    temperature = to.temperature,
                    humidity = to.humidity,
                    pressure = to.pressure
            )
}