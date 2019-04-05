package com.ikurek.hometrack.domain.entity

import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class WeatherLog(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column
        val temperature: Double,

        @Column
        val humidity: Double,

        @Column
        val pressure: Double,

        @Column
        val date: ZonedDateTime = ZonedDateTime.now()
)