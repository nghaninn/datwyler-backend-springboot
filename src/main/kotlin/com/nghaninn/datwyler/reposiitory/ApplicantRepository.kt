package com.nghaninn.datwyler.reposiitory

import com.nghaninn.datwyler.entity.Applicant
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path="applicant")
interface ApplicantRepository : CrudRepository<Applicant, Int>{
}