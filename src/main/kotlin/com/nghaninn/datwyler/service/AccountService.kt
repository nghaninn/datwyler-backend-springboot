package com.nghaninn.datwyler.service

import com.nghaninn.datwyler.dto.AccountDTO
import com.nghaninn.datwyler.dto.ApplicantDTO
import com.nghaninn.datwyler.dto.LoanDTO
import com.nghaninn.datwyler.entity.Account
import com.nghaninn.datwyler.reposiitory.AccountRepository
import com.nghaninn.datwyler.reposiitory.ApplicantRepository
import org.springframework.stereotype.Service

@Service
class AccountService (
    val accountRepository: AccountRepository,
    val applicantRepository: ApplicantRepository,
) {
    fun create(applicantID: Int, accountDTO: AccountDTO?) {
        val applicantResult = applicantRepository.findById(applicantID)

        if (applicantResult.isPresent) {
            val applicant = applicantResult.get()
            val accountEntity: Account = applicantID.let {
                Account(null, applicant)
            }
            accountRepository.save(accountEntity)
        } else {
            throw Exception("Applicant does not exist")
        }
    }

    fun get(applicantID: Int, accountID: Int): AccountDTO {
        val accountResult = accountRepository.findById(accountID)
        return if (accountResult.isPresent) {
            accountResult.get().let {
                AccountDTO(it.id, it.applicant!!.id!!, it.loans!!
                    .map{ loan -> LoanDTO(loan.id, loan.amount, loan.start, loan.durationDays, it.id!!) }
                )
            }
        } else {
            throw Exception("Account does not exist")
        }
    }

    fun list(applicantID: Int): List<AccountDTO> {
        val applicantResult = applicantRepository.findById(applicantID)

        return if (applicantResult.isPresent) {
            applicantResult.get().let {
                it.accounts!!.map { acc ->
                    AccountDTO(acc.id, it.id!!, acc.loans!!
                        .map{ loan -> LoanDTO(loan.id, loan.amount, loan.start, loan.durationDays, acc.id!!) }
                    )
                }
            }
        } else {
            throw Exception("Applicant does not exist")
        }
    }

}
