package com.nghaninn.datwyler.configuration

import com.nghaninn.datwyler.service.UserService
import com.nghaninn.datwyler.utility.JWTUtility
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilter: OncePerRequestFilter() {

    @Autowired
    lateinit var jwtUtility: JWTUtility

    @Autowired
    lateinit var userService: UserService

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        if (!request.requestURL.contains("/user/authenticate") ||
            !request.requestURL.contains("/h2-console")
        ) {
            println(request.requestURL)


            var authorization = request.getHeader("Authorization")
            if (!authorization.isNullOrEmpty() && authorization.startsWith("Bearer ")) {
                var token = authorization.substring(7)
                var claims = jwtUtility.getClaimsFromToken(token)

                if (SecurityContextHolder.getContext().authentication == null) {
                    var userDetails = userService.loadUserByUsername(claims.subject)

                    if (jwtUtility.isValidToken(claims, userDetails)) {
                        val usernamePasswordAuthenticationToken =
                            UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)

                        usernamePasswordAuthenticationToken.details =
                            WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
                    }
                }
            }
        }

        filterChain.doFilter(request, response)
    }
}