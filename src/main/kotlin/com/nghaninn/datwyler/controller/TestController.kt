package com.nghaninn.datwyler.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/")
class TestController {

    @GetMapping("/")
    fun login(): String {
        return "HELLO"
    }
}