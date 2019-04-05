package com.ikurek.hometrack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeTrackRemoteApplication

fun main(args: Array<String>) {
    runApplication<HomeTrackRemoteApplication>(*args)
}
