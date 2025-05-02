package com.range.kotlinDm.service.impl


import com.range.kotlinDm.mapper.Usermapper
import com.range.kotlinDm.model.Role
import com.range.kotlinDm.model.User
import com.range.kotlinDm.repo.UserRepo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.springframework.security.crypto.password.PasswordEncoder
import kotlin.test.assertEquals

class UserServiceImplTest {
 private lateinit var userService: UserServiceImpl
 private lateinit var userRepo: UserRepo
 private lateinit var passwordEncoder: PasswordEncoder
 private lateinit var dummyUser: User
 private lateinit var dummyUser2: User
 private lateinit var dummyUserSList: List<User>
 @BeforeEach
 fun setUp() {
  dummyUser = User(1,"sdfkjmsdfkd","123123123","ldk@gmail.com",Role.ROLE_USER)
  dummyUser2 = User(2,"sdfkjmsrandmdfkd","123123123","ldk2@gmail.com",Role.ROLE_USER)
  dummyUserSList = listOf(dummyUser, dummyUser2)
  userRepo= mock(UserRepo::class.java)
  passwordEncoder = mock(PasswordEncoder::class.java)
  userService = UserServiceImpl(userRepo, passwordEncoder)
 }

 @Test
 fun searchUser() {
  Mockito.`when`(userRepo.findUserByUsernameField(anyString())).thenReturn(dummyUser)
  val expected = Usermapper.fromUserToUserDataResponse(dummyUser)
  assertEquals(userService.searchUser("aas"),expected)
 }

 @Test
 fun registerUser() {}

 @Test
 fun  `when userrepo is not have any entity get all users`() {
  Mockito.`when`(userRepo.findAll()).thenReturn(listOf())
  assert(userService.getAllUsers().isEmpty())
 }

 @Test
 fun `when userService get all users called but in user repo has users `(){
  Mockito.`when`(userRepo.findAll()).thenReturn(dummyUserSList)
  val expected = dummyUserSList.map { Usermapper.fromUserToUserDataResponse(it) }
  assertEquals(userService.getAllUsers(), expected)
 }


}
