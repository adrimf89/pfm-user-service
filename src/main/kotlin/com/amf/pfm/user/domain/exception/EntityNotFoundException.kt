package com.amf.pfm.user.domain.exception

import org.aspectj.bridge.Message
import java.util.UUID

class EntityNotFoundException(
    exceptionMessage: String = "Entity not found",
) : UserServiceException(exceptionMessage) {

    companion object {
        fun userNotFound(userId: UUID) = UserServiceException(USER_NOT_FOUND.format(userId))
    }
}