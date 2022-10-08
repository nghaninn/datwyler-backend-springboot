package com.nghaninn.datwyler.controller

import com.nghaninn.datwyler.dto.AccountDTO
import com.nghaninn.datwyler.dto.ApplicantDTO
import com.nghaninn.datwyler.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("applicant/{applicantID}/account")
class AccountController (
  val accountService: AccountService
) {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun create(
    @PathVariable("applicantID") applicantID: Int,
    @RequestBody accountDTO: AccountDTO?
  ) = accountService.create(applicantID, accountDTO)

  @GetMapping("/{accountID}")
  fun get(
    @PathVariable("applicantID") applicantID: Int,
    @PathVariable("accountID") accountID: Int
  ): AccountDTO = accountService.get(applicantID, accountID)

  @GetMapping
  fun list(
    @PathVariable("applicantID") applicantID: Int,
    @RequestParam("limit", required = false) limit: Int?,
    @RequestParam("offset", required = false) offset: Int?,
  ): List<AccountDTO> = accountService.list(applicantID)
}