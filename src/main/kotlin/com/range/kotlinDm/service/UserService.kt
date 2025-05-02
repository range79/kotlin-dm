package com.range.kotlinDm.service

import com.range.kotlinDm.dto.RegisterRequest
import com.range.kotlinDm.dto.UserDataResponse

interface UserService {

    /**
     * Searches for a specific user by username and returns public user information.
     * Private fields (e.g. password) are excluded from the response.
     */
    fun searchUser(username: String): UserDataResponse

    /**
     * Registers a new user in the system and persists their data in the database.
     * Returns the saved user's public information.
     */
    fun registerUser(registerRequest: RegisterRequest): UserDataResponse

    /**
     * Retrieves all users with only their public information.
     * Private data is excluded from the result list.
     */
    fun getAllUsers(): List<UserDataResponse>
}
