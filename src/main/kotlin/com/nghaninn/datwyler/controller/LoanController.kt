package com.nghaninn.datwyler.controller

import com.nghaninn.datwyler.dto.LoanDTO
import com.nghaninn.datwyler.service.LoanService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("applicant/{applicantID}/account/{accountID}/loan")
class LoanController (
    val loanService: LoanService
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @PathVariable("applicantID") applicantID: Int,
        @PathVariable("accountID") accountID: Int,
        @RequestBody loanDTO: LoanDTO?
    ) = loanService.create(applicantID, accountID, loanDTO)

    @GetMapping("/{loanID}")
    fun get(
        @PathVariable("applicantID") applicantID: Int,
        @PathVariable("accountID") accountID: Int,
        @PathVariable("loanID") loanID: Int
    ): LoanDTO = loanService.get(applicantID, accountID, loanID)

    @GetMapping
    fun list(
        @PathVariable("applicantID") applicantID: Int,
        @PathVariable("accountID") accountID: Int,
        @RequestParam("limit", required = false) limit: Int?,
        @RequestParam("offset", required = false) offset: Int?,
    ): List<LoanDTO> = loanService.list(applicantID, accountID)
}