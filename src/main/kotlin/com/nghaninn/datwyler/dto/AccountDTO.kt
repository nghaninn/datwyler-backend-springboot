package com.nghaninn.datwyler.dto

import com.nghaninn.datwyler.entity.Applicant

data class AccountDTO(
    var id: Int?,
    var applicantID: Int,

    var loans: List<LoanDTO>? = mutableListOf(),
)
