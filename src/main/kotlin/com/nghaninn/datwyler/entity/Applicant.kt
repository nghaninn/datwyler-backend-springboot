package com.nghaninn.datwyler.entity

import javax.persistence.*

@Entity
@Table(name="Applicant")
data class Applicant (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var name: String,

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy="applicant",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var accounts: List<Account>? = mutableListOf()
)