package com.amf.pfm.user.domain.exception

open class UserException(
    override val message: String,
    cause: Throwable? = null
) : UserServiceException(message, cause) {

    companion object {
        fun userWithMissingUsername(): UserException {
            return UserException(USER_WITH_MISSING_USERNAME)
        }

        fun userWithMissingPassword(): UserException {
            return UserException(USER_WITH_MISSING_PASSWORD)
        }

        fun userWithMissingFirstName(): UserException {
            return UserException(USER_WITH_MISSING_FIRST_NAME)
        }

        fun userWithMissingLastName(): UserException {
            return UserException(USER_WITH_MISSING_LAST_NAME)
        }
    }
}