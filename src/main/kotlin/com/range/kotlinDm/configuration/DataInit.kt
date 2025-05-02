package com.range.kotlinDm.configuration

import com.range.kotlinDm.model.Role
import com.range.kotlinDm.model.User
import com.range.kotlinDm.repo.UserRepo
import jakarta.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
@Transactional
@Configuration
class DataInit {
    @Value("\${user.name}")
    var username:String?=null
    @Value("\${user.password}")
    var password:String?=null
    @Value("\${user.email}")
    var email:String?=null
    private val log:Logger = LoggerFactory.getLogger(DataInit::class.java)
    @Bean
    fun init(userRepo: UserRepo, passwordEncoder: BCryptPasswordEncoder):CommandLineRunner {
return CommandLineRunner {
    if (username.isNullOrEmpty()) {
        throw IllegalArgumentException("Username cannot be null or empty")
    }
    if (userRepo.existsUserByUsernameField(username!!)==false){
        val admin = User(usernameField =  username!!
            , passwordField =  passwordEncoder.encode( password!!)
            , email = email!!
            , role = Role.ROLE_ADMIN)

        userRepo.save(admin)
        log.info("Saved admin ${admin.username}")
    }else{
        log.info("ℹ️ Admin user already exists. Skipping creation.")

    }

}
}

}