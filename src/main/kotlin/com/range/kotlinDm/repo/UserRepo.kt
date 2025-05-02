package com.range.kotlinDm.repo

import com.range.kotlinDm.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo:JpaRepository<User,Long> {
    fun findUserByUsernameField(usernameField: String): User?
    fun existsUserByUsernameField(username: String): Boolean
}