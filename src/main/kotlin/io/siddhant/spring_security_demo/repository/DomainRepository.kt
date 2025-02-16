package io.siddhant.spring_security_demo.repository

import io.siddhant.spring_security_demo.domain.Domain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DomainRepository : JpaRepository<Domain, Long> {
}