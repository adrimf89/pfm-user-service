package com.amf.pfm.user.domain.exception

class EntityConflictException(
    override val message: String,
    cause: Throwable? = null,
) : UserServiceException(message, cause) {

    companion object {
        fun userWithUsernameAlreadyExists(username: String): EntityConflictException {
            return EntityConflictException(USER_USERNAME_ALREADY_EXISTS.format(username))
        }
    }
}