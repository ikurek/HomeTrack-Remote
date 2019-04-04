package com.ikurek.hometrack.infrastructure.resource

import com.ikurek.hometrack.domain.dto.TodayDTO
import com.ikurek.hometrack.domain.dto.WeatherLogDTO
import com.ikurek.hometrack.infrastructure.service.WeatherLogService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherLogResource(
        val weatherLogService: WeatherLogService
) {

    @GetMapping("/api/log")
    fun getLatest(): ResponseEntity<WeatherLogDTO> =
            ResponseEntity(
                    weatherLogService.getLatest(),
                    HttpStatus.OK
            )


    @PostMapping("/api/log")
    fun addLog(@RequestBody @Validated weatherLogDTO: WeatherLogDTO): ResponseEntity<WeatherLogDTO> =
            ResponseEntity(
                    weatherLogService.addLog(weatherLogDTO),
                    HttpStatus.CREATED
            )

    @GetMapping("/api/today")
    fun getToday(): ResponseEntity<TodayDTO> =
            ResponseEntity(
                    weatherLogService.getToday(),
                    HttpStatus.OK
            )

}