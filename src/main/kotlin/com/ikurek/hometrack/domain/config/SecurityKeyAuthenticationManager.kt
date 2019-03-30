package com.ikurek.hometrack.domain.config

import com.ikurek.hometrack.domain.exception.BadCredentialsException
import com.ikurek.hometrack.domain.exception.UnauthorizedException
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication

class SecurityKeyAuthenticationManager(val principalRequestToken: String) : AuthenticationManager {

    override fun authenticate(authentication: Authentication?): Authentication {

        when {
            authentication == null -> throw UnauthorizedException()
            principalRequestToken == authentication.principal -> {
                authentication.isAuthenticated = true
                return authentication
            }
            else -> throw BadCredentialsException()
        }
    }
}