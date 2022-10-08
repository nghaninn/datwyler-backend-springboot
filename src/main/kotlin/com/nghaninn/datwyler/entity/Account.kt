package com.nghaninn.datwyler.entity

import javax.persistence.*

@Entity
@Table(name="Account")
class Account (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="applicantID", nullable = false)
    var applicant: Applicant? = null,

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy="account",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var loans: List<Loan>? = mutableListOf()
) {

    override fun toString(): String {
        return "Account(id=$id, applicant=${applicant!!.id})"
    }
}