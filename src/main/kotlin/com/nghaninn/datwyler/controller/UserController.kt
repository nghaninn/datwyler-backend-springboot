package com.nghaninn.datwyler.controller

import com.nghaninn.datwyler.dto.AuthenticationRequestDTO
import com.nghaninn.datwyler.dto.AuthenticationResponseDTO
import com.nghaninn.datwyler.enums.UserType
import com.nghaninn.datwyler.service.UserService
import com.nghaninn.datwyler.utility.JWTUtility
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var jwtUtility: JWTUtility

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/login")
    fun home(model: Model?, principal: Principal): String? {
        return principal.toString();
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody authRequest: AuthenticationRequestDTO): AuthenticationResponseDTO {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
        )

        var token = jwtUtility.generateToken(authRequest.username, UserType.USER)

        return AuthenticationResponseDTO(token)
    }

    @GetMapping("/test")
    fun test(): String {
        return "Hello"
    }
}