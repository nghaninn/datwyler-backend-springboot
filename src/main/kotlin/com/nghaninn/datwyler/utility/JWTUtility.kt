package com.nghaninn.datwyler.utility

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*

const val claimsKey = "scopes"
//const val signingKey = "SIGNINGKEY"
const val issuer = "ISSUER"


const val EXPIRE_DATE = 10 * 24 * 60 * 60 * 1000

@Component
class JWTUtility : Serializable {

    @Value("\${jwt.secret}")
    private val secretKey: String? = null

    /**
     * To get the <Claims> using the token
     *
     * @param token - Unique token
     *
     * @return <Claims> objects, contains mainly, userName(in subject), expireTime, role(in audience)
     */
    fun getClaimsFromToken(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .body
    }

    /**
     * To generate the auth token using userName and the role
     *
     * @param userName  -   unique username
     * @param role      -   role for the user {1 -> Super Admin, 2 -> Admin, Level1 - {100 - 199},.. ,LevelX - {X00 - X99}}
     *
     * @return unique token for the session using userName and the role
     */
    fun generateToken(userName: String, role: com.nghaninn.datwyler.enums.UserType): String {
        val claims: Claims = Jwts.claims().setSubject(userName).setAudience(role.toString())
        claims.put(claimsKey, listOf(SimpleGrantedAuthority(role.toString())))

        return Jwts.builder().setClaims(claims).setIssuer(issuer).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + EXPIRE_DATE)).signWith(SignatureAlgorithm.HS256, secretKey).compact()
    }

    /**
     * To check the token is valid or not using <Claims> and <UserDetails> </BR>
     *
     * @param <Claims?> object from the token
     * @param <UserDetails> object
     *
     * @return true -> if the token is valid(checking the username and the expire time), false otherwise
     */
    fun isValidToken(claims: Claims?, userDetails: UserDetails): Boolean = claims?.let {
        return it.subject.equals(userDetails.username, true) && !(it.expiration?.before(Date()) ?: true)
    } ?: false
}