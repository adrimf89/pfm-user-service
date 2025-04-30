package com.amf.pfm.user.infrastructure.rest.user.request

import com.amf.pfm.user.application.user.CreateUserRequest

class UserRestRequest(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String
) {

    fun toCreateUserRequest(): CreateUserRequest {
        return CreateUserRequest(
            username = username,
            password = password,
            firstName = firstName,
            lastName = lastName
        )
    }
}