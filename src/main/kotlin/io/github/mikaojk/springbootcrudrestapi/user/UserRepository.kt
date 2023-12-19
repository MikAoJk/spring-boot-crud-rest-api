package io.github.mikaojk.springbootcrudrestapi.user

import org.springframework.data.repository.CrudRepository

import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>