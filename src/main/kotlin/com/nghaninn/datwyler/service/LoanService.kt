package com.nghaninn.datwyler.service

import com.nghaninn.datwyler.dto.LoanDTO
import com.nghaninn.datwyler.entity.Loan
import com.nghaninn.datwyler.reposiitory.AccountRepository
import com.nghaninn.datwyler.reposiitory.ApplicantRepository
import com.nghaninn.datwyler.reposiitory.LoanRepository
import org.springframework.stereotype.Service

@Service
class LoanService (
    val applicantRepository: ApplicantRepository,
    val accountRepository: AccountRepository,
    val loanRepository: LoanRepository,
){
    fun create(applicantID: Int, accountID: Int, loanDTO: LoanDTO?) {
        val accountResult = accountRepository.findById(accountID)

        if (accountResult.isPresent) {
            val account = accountResult.get()
            if (account.applicant!!.id == applicantID) {
                val loanEntity:Loan = loanDTO.let {
                    Loan(null, it!!.amount, it!!.start, it!!.durationDays, it.type!!, account)
                }

                loanRepository.save(loanEntity)
            }
        } else {
            throw Exception("Account does not exist")
        }
    }

    fun get(applicantID: Int, accountID: Int, loanID: Int): LoanDTO {
        val loanResult = loanRepository.findById(loanID)

        return if (loanResult.isPresent) {
            loanResult.get().let {
                LoanDTO(it.id, it.amount, it.start, it.durationDays, it.type, it.account!!.id!!)
            }
        } else {
            throw Exception("Loan does not exist")
        }
    }

    fun list(applicantID: Int, accountID: Int): List<LoanDTO> {
        val accountResult = accountRepository.findById(accountID)

        return if (accountResult.isPresent) {
            accountResult.get().let {
                it.loans!!.map { loan ->
                    LoanDTO(loan.id, loan.amount, loan.start, loan.durationDays, loan.type, it.id!!)
                }
            }
        } else {
            throw Exception("Account does not exist")
        }
    }
}
