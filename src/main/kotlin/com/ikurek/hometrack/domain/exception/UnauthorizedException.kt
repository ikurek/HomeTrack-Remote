package com.ikurek.hometrack.domain.exception

import org.springframework.http.HttpStatus
import javax.xml.ws.http.HTTPException

class UnauthorizedException(
        status: HttpStatus = HttpStatus.UNAUTHORIZED
) : HTTPException(status.value())