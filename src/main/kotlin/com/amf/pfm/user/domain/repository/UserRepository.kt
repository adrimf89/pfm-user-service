package com.amf.pfm.user.domain.repository

import com.amf.pfm.user.domain.model.User
import java.util.UUID

interface UserRepository {
    fun save(user: User): User
    fun findById(id: UUID): User
    fun findAll(): List<User>
    fun existsByUsername(username: String): Boolean
}