package com.ikurek.hometrack.infrastructure.controller

import com.ikurek.hometrack.domain.dto.TodayDTO
import com.ikurek.hometrack.domain.dto.WeatherLogDTO
import com.ikurek.hometrack.infrastructure.service.WeatherLogService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path = ["/api"])
class WeatherLogController(
        val weatherLogService: WeatherLogService
) {

    @GetMapping("/log")
    fun getLatest(): ResponseEntity<WeatherLogDTO> {
        return ResponseEntity(
                weatherLogService.getLatest(),
                HttpStatus.OK
        )
    }


    @PostMapping("/log")
    fun addLog(@RequestBody @Validated weatherLogDTO: WeatherLogDTO): ResponseEntity<WeatherLogDTO> {
        return ResponseEntity(
                weatherLogService.addLog(weatherLogDTO),
                HttpStatus.CREATED
        )
    }

    @GetMapping("/today")
    fun getToday(): ResponseEntity<TodayDTO> {
        return ResponseEntity(
                weatherLogService.getToday(),
                HttpStatus.OK
        )
    }

}