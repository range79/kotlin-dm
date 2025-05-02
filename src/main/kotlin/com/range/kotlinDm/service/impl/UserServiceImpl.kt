package com.range.kotlinDm.service.impl

import com.range.kotlinDm.dto.RegisterRequest
import com.range.kotlinDm.dto.UserDataResponse
import com.range.kotlinDm.mapper.Usermapper
import com.range.kotlinDm.model.User
import com.range.kotlinDm.repo.UserRepo
import com.range.kotlinDm.service.UserService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepo: UserRepo,
    private val passwordEncoder: org.springframework.security.crypto.password.PasswordEncoder

):UserService {

    override fun searchUser(username: String): UserDataResponse {
       val  user = userRepo.findUserByUsernameField(username) ?:
        throw UsernameNotFoundException("Username not found")
        return UserDataResponse(user.usernameField,user.email)
    }

    override fun registerUser(registerRequest: RegisterRequest): UserDataResponse {
        var user:User =Usermapper.fromRegisterRequesttoUser(registerRequest)
        var check: Boolean = userRepo.existsUserByUsernameField(user.username);
        if(check){
            throw RuntimeException("User already exists")
        }

        var encodedUser = user.copy(passwordField = passwordEncoder.encode(user.password))
         userRepo.save(encodedUser)
        return Usermapper.fromUserToUserDataResponse(encodedUser)
    }

    override fun getAllUsers(): List<UserDataResponse> {
        var users: List<UserDataResponse> =userRepo.findAll()
            .stream()
            //convert to UserDataResponse
            .map{Usermapper.fromUserToUserDataResponse(it)}.toList()
        return  users;

    }


}