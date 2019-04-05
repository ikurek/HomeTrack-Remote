package com.ikurek.hometrack.domain.dto

data class TodayDTO(
        val avgTemperature: Double,
        val minTemperature: Double,
        val maxTemperature: Double,
        val avgHumidity: Double,
        val minHumidity: Double,
        val maxHumidity: Double,
        val avgPressure: Double,
        val minPressure: Double,
        val maxPressure: Double,
        val weatherLog: List<WeatherLogDTO>
)