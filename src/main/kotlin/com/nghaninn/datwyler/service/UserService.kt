package com.nghaninn.datwyler.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {

        return User("admin", "password", listOf());
    }
}