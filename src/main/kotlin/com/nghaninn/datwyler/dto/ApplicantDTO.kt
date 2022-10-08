package com.nghaninn.datwyler.dto

data class ApplicantDTO (
    var id: Int?,
    var name: String,

    var accounts: List<AccountDTO>? = mutableListOf(),
)
