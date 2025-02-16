package io.siddhant.spring_security_demo.repository

import io.siddhant.spring_security_demo.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    abstract fun findByUsernameIgnoreCase(username: String?): User?
}