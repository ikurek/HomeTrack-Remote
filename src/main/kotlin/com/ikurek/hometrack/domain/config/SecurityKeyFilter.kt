package com.ikurek.hometrack.domain.config

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

class SecurityKeyFilter(private val requestHeader: String): AbstractPreAuthenticatedProcessingFilter() {
    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any? =
            Object()

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest): Any? {
        val header = request.getHeader(requestHeader)
        return header
    }

}