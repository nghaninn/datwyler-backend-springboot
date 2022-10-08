package com.nghaninn.datwyler.reposiitory

import com.nghaninn.datwyler.entity.Loan
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.webmvc.RepositoryRestController

@RepositoryRestResource(path="loan")
interface LoanRepository : CrudRepository<Loan, Int> {

}
