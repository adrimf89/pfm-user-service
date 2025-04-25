package com.amf.pfm.user.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController {

    data class User(
        val id: UUID = UUID.randomUUID(),
        val name: String,
        val username: String,
        val password: String
    )

    companion object {
        private val users = mutableMapOf<UUID, User>()
    }

    @PostMapping
    fun createUser(@RequestBody userRequest: CreateUserRequest): ResponseEntity<User> {
        val user = User(
            name = userRequest.name,
            username = userRequest.username,
            password = userRequest.password
        )
        users[user.id] = user
        return ResponseEntity.ok(user)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): ResponseEntity<User> {
        val user = users[id]
        return if (user != null) ResponseEntity.ok(user)
        else ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(users.values.toList())
    }

    data class CreateUserRequest(
        val name: String,
        val username: String,
        val password: String
    )
}