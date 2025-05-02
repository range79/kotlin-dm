package com.range.kotlinDm.mapper

import com.range.kotlinDm.dto.RegisterRequest
import com.range.kotlinDm.dto.UserDataResponse
import com.range.kotlinDm.model.Role
import com.range.kotlinDm.model.User

object Usermapper {
    /**
     * Converts a RegisterRequest into a User entity.
     */
    fun fromRegisterRequesttoUser(registerRequest: RegisterRequest): User {
        return User(usernameField = registerRequest.username,
            passwordField = registerRequest.password,
            role = Role.ROLE_USER,
            email = registerRequest.email,
        )
    }

    fun fromUserToUserDataResponse(User:User):UserDataResponse {
        return UserDataResponse(
            name = User.username,
            email = User.email,

            )

    }


}