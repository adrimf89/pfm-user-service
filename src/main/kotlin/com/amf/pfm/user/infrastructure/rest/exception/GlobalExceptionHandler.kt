package com.amf.pfm.user.infrastructure.rest.exception

import com.amf.pfm.user.domain.exception.EMPTY_STRING
import com.amf.pfm.user.domain.exception.EntityConflictException
import com.amf.pfm.user.domain.exception.EntityNotFoundException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(value = [Exception::class])
    fun defaultHandler(exception: Exception): ResponseEntity<ErrorResponse> {
        return handleException(exception, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleEntityNotFoundException(exception: Exception): ResponseEntity<ErrorResponse> {
        return handleException(exception, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [EntityConflictException::class])
    fun handleEntityConflictException(exception: Exception): ResponseEntity<ErrorResponse> {
        return handleException(exception, HttpStatus.CONFLICT)
    }

    private fun handleException(exception: Exception, status: HttpStatus): ResponseEntity<ErrorResponse> {
        val body = ErrorResponse(exception.message ?: EMPTY_STRING)
        logger.error(exception) { "Error with status: $status and message: ${exception.message}" }
        return ResponseEntity(body, status)
    }
}

data class ErrorResponse(
    val message: String,
)