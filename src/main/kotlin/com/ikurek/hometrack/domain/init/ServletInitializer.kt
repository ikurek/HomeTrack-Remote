package com.ikurek.hometrack.domain.init

import com.ikurek.hometrack.HomeTrackApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(HomeTrackApplication::class.java)
    }

}
