package com.nghaninn.datwyler.service

import com.nghaninn.datwyler.dto.AccountDTO
import com.nghaninn.datwyler.dto.ApplicantDTO
import com.nghaninn.datwyler.dto.LoanDTO
import com.nghaninn.datwyler.entity.Applicant
import com.nghaninn.datwyler.reposiitory.ApplicantRepository
import org.springframework.stereotype.Service

@Service
class ApplicantService (
    val applicantRepository: ApplicantRepository
){

    fun create(applicantDTO: ApplicantDTO) {
        val applicantEntity = applicantDTO.let { Applicant(null, it.name) }

        applicantRepository.save(applicantEntity);
    }

    fun get(applicantID: Int): ApplicantDTO {
        val applicantResult = applicantRepository.findById((applicantID))

        return if (applicantResult.isPresent) {
            applicantResult.get().let {
                ApplicantDTO(it.id, it.name, it.accounts!!
                    .map {acc ->
                        AccountDTO(acc.id!!, it.id!!, acc.loans!!
                            .map{ loan -> LoanDTO(loan.id, loan.amount, loan.start, loan.durationDays, loan.type, acc.id!!) }
                        )
                    })
            }
        } else {
            throw Exception("Not found")
        }
    }

    fun list(limit: Int?, offset: Int?): List<ApplicantDTO> {
        val applicantResult = applicantRepository.findAll()

        return applicantResult.asSequence()
            .map{
                ApplicantDTO(it.id, it.name, it.accounts!!
                    .map {acc ->
                        AccountDTO(acc.id!!, it.id!!, acc.loans!!
                            .map{ loan -> LoanDTO(loan.id, loan.amount, loan.start, loan.durationDays, loan.type, acc.id!!) }
                        )
                    })
            }
            .toList()
    }


}
