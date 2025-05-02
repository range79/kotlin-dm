package com.range.kotlinDm.configuration

import com.range.kotlinDm.configuration.util.PasswordEncoderConfig
import com.range.kotlinDm.model.Role
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val passwordEncoderConfig: PasswordEncoderConfig,
    private val userDetailsService: UserDetailsService

) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf{it.disable() }
            .authorizeHttpRequests{
                it.requestMatchers(
                    "/register",
                ).permitAll()
                    .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/v3/api-docs.yaml").hasAuthority(Role.ROLE_ADMIN.name)
                it.anyRequest().authenticated()
            }
            .httpBasic(Customizer.withDefaults())
        return http.build()

    }
    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setPasswordEncoder(passwordEncoderConfig.passwordEncoder())
        authProvider.setUserDetailsService(userDetailsService)
        return authProvider
    }

}