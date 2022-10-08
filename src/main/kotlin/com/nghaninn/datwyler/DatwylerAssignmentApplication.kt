package com.nghaninn.datwyler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@SpringBootApplication
class DatwylerAssignmentApplication {

	@Bean
	fun passowrdEncoder() : PasswordEncoder {
		return NoOpPasswordEncoder.getInstance();
	}
}

fun main(args: Array<String>) {
	runApplication<DatwylerAssignmentApplication>(*args)
}
