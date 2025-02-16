package io.siddhant.spring_security_demo.repository

interface DomainRepository: org.springframework.data.jpa.repository.JpaRepository<io.siddhant.spring_security_demo.domain.Domain, kotlin.Long> {
}