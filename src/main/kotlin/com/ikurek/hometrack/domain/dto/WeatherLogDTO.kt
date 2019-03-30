package com.ikurek.hometrack.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

data class WeatherLogDTO(

        @field:JsonProperty(required = false)
        val id: Long?,

        @field:JsonProperty(required = true)
        val temperature: Double,

        @field:JsonProperty(required = true)
        val humidity: Double,

        @field:JsonProperty(required = true)
        val pressure: Double,

        @field:JsonProperty(required = false)
        val date: ZonedDateTime?
)