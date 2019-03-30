package com.ikurek.hometrack.domain.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Value("\${hometrack.auth.header}")
    private lateinit var header: String

    @Value("\${hometrack.auth.token}")
    private lateinit var token: String

    override fun configure(http: HttpSecurity?) {
        val securityKeyFilter = SecurityKeyFilter(header)
        securityKeyFilter.setAuthenticationManager(SecurityKeyAuthenticationManager(token))

        http?.antMatcher("/api/**")
                ?.csrf()
                ?.disable()
                ?.sessionManagement()
                ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ?.and()
                ?.addFilter(securityKeyFilter)
                ?.authorizeRequests()
                ?.anyRequest()
                ?.authenticated()

    }
}