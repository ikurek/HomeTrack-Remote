package com.ikurek.hometrack.infrastructure.controller

import com.ikurek.hometrack.infrastructure.service.WeatherLogService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.format.DateTimeFormatter

@Controller
@RequestMapping(path = ["/"])
class WebController(
        private val weatherLogService: WeatherLogService
) {

    @GetMapping
    fun getHomePage(model: Model): String {

        val current = weatherLogService.getLatest()
        val today = weatherLogService.getToday()

        model.apply {
            addAttribute("date", DateTimeFormatter.ofPattern("dd.MM.yyy hh:mm:ss").format(current.date))
            addAttribute("temperature", String.format("%.1f", current.temperature))
            addAttribute("humidity", String.format("%.0f", current.humidity))
            addAttribute("pressure", String.format("%.0f", current.pressure))
            addAttribute("avgTemperature", String.format("%.1f", today.avgTemperature))
            addAttribute("avgHumidity", String.format("%.0f", today.avgHumidity))
            addAttribute("avgPressure", String.format("%.0f", today.avgPressure))
            addAttribute("minTemperature", String.format("%.1f", today.minTemperature))
            addAttribute("minHumidity", String.format("%.0f", today.minHumidity))
            addAttribute("minPressure", String.format("%.0f", today.minPressure))
            addAttribute("maxTemperature", String.format("%.1f", today.maxTemperature))
            addAttribute("maxHumidity", String.format("%.0f", today.minHumidity))
            addAttribute("maxPressure", String.format("%.0f", today.maxPressure))
        }
        return "home"
    }
}