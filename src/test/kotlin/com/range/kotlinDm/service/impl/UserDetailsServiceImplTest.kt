package com.range.kotlinDm.service.impl

import com.range.kotlinDm.model.Role
import com.range.kotlinDm.model.User
import com.range.kotlinDm.repo.UserRepo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mockito

class UserDetailsServiceImplTest {
 private lateinit var userRepo: UserRepo
 private lateinit var dummyUser: User
 private lateinit var userDetailsServiceImpl: UserDetailsServiceImpl


 @BeforeEach
 fun setUp() {
  userRepo= Mockito.mock(UserRepo::class.java)
  dummyUser= User(1,"test","test","test",Role.ROLE_USER)
  userDetailsServiceImpl = UserDetailsServiceImpl(userRepo)
 }


 @Test
 fun `should get user when username is valid`() {

  Mockito.`when`(userRepo.findUserByUsernameField(anyString())).thenReturn(dummyUser)
  kotlin.test.assertEquals(userDetailsServiceImpl.loadUserByUsername("aa"), dummyUser)
 }
@Test
fun `should get user when username is empty`() {
assertThrows<RuntimeException> {userDetailsServiceImpl.loadUserByUsername("")}

}

}

