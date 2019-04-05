package com.ikurek.hometrack.domain.exception

import org.springframework.http.HttpStatus
import javax.xml.ws.http.HTTPException

class NoEntriesTodayException(
        status: HttpStatus = HttpStatus.NOT_FOUND
) : HTTPException(status.value())