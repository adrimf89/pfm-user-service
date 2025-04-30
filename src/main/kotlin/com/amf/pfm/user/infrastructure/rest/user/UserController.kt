package com.amf.pfm.user.infrastructure.rest.user

import com.amf.pfm.user.application.user.UserService
import com.amf.pfm.user.infrastructure.rest.user.request.UserRestRequest
import com.amf.pfm.user.infrastructure.rest.user.response.UserRestResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody userRequest: UserRestRequest): ResponseEntity<UserRestResponse> {
        val request = userRequest.toCreateUserRequest()
        val user = userService.createUser(request)
        return ResponseEntity.ok(UserRestResponse(user))
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): ResponseEntity<UserRestResponse> {
        val user = userService.getUserById(id)
        return ResponseEntity.ok(UserRestResponse(user))
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserRestResponse>> {
        val users = userService.getAllUsers()
        return ResponseEntity.ok(users.map { UserRestResponse(it) })
    }
}