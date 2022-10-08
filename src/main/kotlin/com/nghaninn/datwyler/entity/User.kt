package com.nghaninn.datwyler.entity

import com.nghaninn.datwyler.enums.UserType
import javax.persistence.*

@Entity
@Table(name = "Users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    var type: UserType,

//    @Column(unique = true, nullable = true)
    var email: String,

    @Column
    var name: String,

    @Column
    var password: String
)
