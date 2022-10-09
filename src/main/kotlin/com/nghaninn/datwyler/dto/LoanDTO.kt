package com.nghaninn.datwyler.dto

import com.nghaninn.datwyler.entity.Account
import com.nghaninn.datwyler.enums.LoanType
import java.util.*

data class LoanDTO (
    var id: Int?,
    var amount: Float,
    var start: Date,
    var durationDays: Int,
    var type: LoanType? = LoanType.HOME,

    var accountID: Int
)