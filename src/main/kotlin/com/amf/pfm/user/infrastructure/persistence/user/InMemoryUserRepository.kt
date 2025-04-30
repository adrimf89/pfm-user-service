package com.amf.pfm.user.infrastructure.persistence.user

import com.amf.pfm.user.domain.exception.EntityNotFoundException
import com.amf.pfm.user.domain.model.User
import com.amf.pfm.user.domain.repository.UserRepository
import org.springframework.stereotype.Repository
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.NoSuchElementException

@Repository
class InMemoryUserRepository : UserRepository {

    private val users = ConcurrentHashMap<UUID, User>()

    override fun save(user: User): User {
        users[user.id] = user
        return user
    }

    override fun findById(id: UUID): User {
        return users[id] ?: throw EntityNotFoundException.userNotFound(id)
    }

    override fun findAll(): List<User> {
        return users.values.toList()
    }

    override fun existsByUsername(username: String): Boolean {
        return users.values.any { it.username == username }
    }
}