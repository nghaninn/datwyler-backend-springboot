package com.nghaninn.datwyler.reposiitory

import com.nghaninn.datwyler.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path="user")
interface UserRepository : CrudRepository<User, Int>{
}