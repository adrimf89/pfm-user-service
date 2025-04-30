package com.amf.pfm.user.domain.model

import com.amf.pfm.user.domain.exception.UserException
import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String
) {

    init {
        mustContainValidFields()
    }

    private fun mustContainValidFields() {
        if (username.isBlank()) {
            throw UserException.userWithMissingUsername()
        }
        if (password.isBlank()) {
            throw UserException.userWithMissingPassword()
        }
        if (firstName.isBlank()) {
            throw UserException.userWithMissingFirstName()
        }
        if (lastName.isBlank()) {
            throw UserException.userWithMissingLastName()
        }
    }

}