package com.amf.pfm.user.infrastructure.rest.user.response

import com.amf.pfm.user.domain.model.User
import java.util.*

data class UserRestResponse(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val username: String) {

    constructor(user: User) : this(
        id = user.id,
        firstName = user.firstName,
        lastName = user.lastName,
        username = user.username
    )
}