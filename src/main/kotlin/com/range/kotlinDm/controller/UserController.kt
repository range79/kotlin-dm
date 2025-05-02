package com.range.kotlinDm.controller

import com.range.kotlinDm.dto.RegisterRequest
import com.range.kotlinDm.dto.UserDataResponse
import com.range.kotlinDm.model.User
import com.range.kotlinDm.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,

) {

    @GetMapping("/{name}")
    fun getUserData(@PathVariable name:String): UserDataResponse {
        return userService.searchUser(name)
    }
    @GetMapping("/all")
    fun getAllUsers():List<UserDataResponse>{
        return userService.getAllUsers()
    }
    @PostMapping(name = "/register")
    fun registerUser(@RequestBody registerRequest: RegisterRequest): UserDataResponse {
        return userService.registerUser(registerRequest)
    }

}