package com.ikurek.hometrack.domain.dto

data class TodayDTO(
        val avgTemperature: Double,
        val avgHumidity: Double,
        val avgPressure: Double,
        val weatherLog: List<WeatherLogDTO>
)