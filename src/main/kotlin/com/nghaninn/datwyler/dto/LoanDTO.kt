package com.nghaninn.datwyler.dto

import com.nghaninn.datwyler.entity.Account
import java.util.*

data class LoanDTO (
    var id: Int?,
    var amount: Float,
    var start: Date,
    var durationDays: Int,

    var accountID: Int
)