package com.range.kotlinDm.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
data class User(


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    @Column(name = "username", nullable = false,unique = true)
    var usernameField: String,
    var passwordField: String,
    var email: String,
    var role: Role
)


    : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(role)
    }

    override fun getPassword()=passwordField


    override fun getUsername()= usernameField
}