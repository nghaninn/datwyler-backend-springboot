package com.nghaninn.datwyler.controller

import com.nghaninn.datwyler.dto.ApplicantDTO
import com.nghaninn.datwyler.service.ApplicantService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/applicant")
class ApplicantController (
    val applicantService: ApplicantService
){


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody applicantDTO: ApplicantDTO) = applicantService.create(applicantDTO)

    @GetMapping("/{applicantID}")
    fun get(@PathVariable("applicantID") applicantID: Int): ApplicantDTO = applicantService.get(applicantID)

    @GetMapping
    fun list(
        @RequestParam("limit", required = false) limit: Int?,
        @RequestParam("offset", required = false) offset: Int?,
    ): List<ApplicantDTO> = applicantService.list(limit, offset)
}