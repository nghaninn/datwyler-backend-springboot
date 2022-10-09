package com.nghaninn.datwyler.entity

import com.nghaninn.datwyler.enums.LoanType
import java.util.Date
import javax.persistence.*

@Entity
@Table(name="Loan")
data class Loan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    var amount: Float,
    var start: Date,
    var durationDays: Int,
    var type: LoanType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID", nullable = false)
    var account: Account? = null
)