package com.nghaninn.datwyler.reposiitory

import com.nghaninn.datwyler.entity.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path="account")
interface AccountRepository : CrudRepository<Account, Int>{

}