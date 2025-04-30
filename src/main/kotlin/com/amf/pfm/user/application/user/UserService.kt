package com.amf.pfm.user.application.user

import com.amf.pfm.user.domain.exception.EntityConflictException
import com.amf.pfm.user.domain.model.User
import com.amf.pfm.user.domain.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(request: CreateUserRequest): User {
        val existsByUsername = userRepository.existsByUsername(request.username)
        if (existsByUsername) {
            throw EntityConflictException.userWithUsernameAlreadyExists(request.username)
        }

        val user = User(
            username = request.username,
            password = request.password,
            firstName = request.firstName,
            lastName = request.lastName
        )
        return userRepository.save(user)
    }

    fun getUserById(id: UUID): User {
        return userRepository.findById(id)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

}

class CreateUserRequest(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String
)