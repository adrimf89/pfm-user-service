package com.amf.pfm.user.domain.exception

open class UserServiceException(override val message: String, cause: Throwable? = null) : Exception(message, cause) {
}